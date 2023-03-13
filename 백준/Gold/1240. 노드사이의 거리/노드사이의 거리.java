import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static int M;
    static boolean[] visited;
    static List<List<int[]>> graph;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        M = Integer.parseInt(values[1]);
        graph = new LinkedList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new LinkedList<>());
        for (int i = 0; i < N - 1; i++) {
            values = br.readLine().split(" ");
            int src = Integer.parseInt(values[0]);
            int dst = Integer.parseInt(values[1]);
            int weight = Integer.parseInt(values[2]);
            graph.get(src).add(new int[]{dst, weight});
            graph.get(dst).add(new int[]{src, weight});
        }
    }

    public static void solve() throws IOException {
        for (int m = 0; m < M; m++) {
            String[] values = br.readLine().split(" ");
            int src = Integer.parseInt(values[0]);
            int dst = Integer.parseInt(values[1]);
            Queue<Integer> que = new LinkedList<>();
            visited = new boolean[N + 1];
            int dist[] = new int[N + 1];
            Arrays.fill(dist, 0);
            que.add(src);
            visited[src] = true;
            while (!que.isEmpty()) {
                int idx = que.poll();
                if (idx == dst)
                    break;
                for (int[] adj : graph.get(idx)) {
                    int node = adj[0];
                    int weight = adj[1];
                    if (!visited[node]) {
                        que.add(node);
                        visited[node] = true;
                        dist[node] = dist[idx] + weight;
                    }
                }
            }
            bw.write(dist[dst] + "\n");
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

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