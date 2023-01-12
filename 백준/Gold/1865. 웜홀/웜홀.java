import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        TC = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        for (int i = 0; i < TC; i++) {
            String[] vars = br.readLine().split(" ");
            N = Integer.parseInt(vars[0]);
            M = Integer.parseInt(vars[1]);
            W = Integer.parseInt(vars[2]);
            graph = new LinkedList<>();
            distance = new int[N];
            Arrays.fill(distance, 99999999);
            for (int j = 0; j < N; j++) graph.add(new LinkedList<>());
            for (int j = 0; j < M; j++) { // add streets
                vars = br.readLine().split(" ");
                int S = Integer.parseInt(vars[0]) - 1;
                int E = Integer.parseInt(vars[1]) - 1;
                int T = Integer.parseInt(vars[2]);
                graph.get(S).add(new int[]{E, T});
                graph.get(E).add(new int[]{S, T});
            }
            for (int j = 0; j < W; j++) { // add wormholes
                vars = br.readLine().split(" ");
                int S = Integer.parseInt(vars[0]) - 1;
                int E = Integer.parseInt(vars[1]) - 1;
                int T = Integer.parseInt(vars[2]);
                graph.get(S).add(new int[]{E, T * (-1)});
            }
            distance[0] = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    List<int[]> vertex = graph.get(k);
                    for (int[] edge : vertex)
                        if (distance[k] + edge[1] < distance[edge[0]])
                            distance[edge[0]] = distance[k] + edge[1];
                }
            }
            boolean hasNegativeCycle = false;
            for (int k = 0; k < N; k++) {
                List<int[]> vertex = graph.get(k);
                for (int[] edge : vertex)
                    if (distance[k] + edge[1] < distance[edge[0]]) {
                        hasNegativeCycle = true;
                        break;
                    }
                if (hasNegativeCycle) break;
            }
            bw.write((hasNegativeCycle ? "YES" : "NO") + "\n");
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int TC;
    static int N;
    static int M;
    static int W;
    static List<List<int[]>> graph;
    static int[] distance;

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }

}