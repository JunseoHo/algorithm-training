import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int M;
    static List<List<int[]>> graph;
    static int departure;
    static int destination;
    static int[] costs;
    static boolean[] visited;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            String[] vars = br.readLine().split(" ");
            int src = Integer.parseInt(vars[0]);
            int dst = Integer.parseInt(vars[1]);
            int cost = Integer.parseInt(vars[2]);
            graph.get(src).add(new int[]{dst, cost});
        }
        String[] vars = br.readLine().split(" ");
        departure = Integer.parseInt(vars[0]);
        destination = Integer.parseInt(vars[1]);
        costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        visited = new boolean[N + 1];
        costs[departure] = 0;
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N - 1; i++) {
            int idx = extractMin();
            visited[idx] = true;
            for (int[] adj : graph.get(idx)) {
                int dst = adj[0];
                int cost = adj[1];
                if (!visited[dst] && costs[dst] > costs[idx] + cost) {
                    costs[dst] = costs[idx] + cost;
                }
            }
        }
        bw.write(String.valueOf(costs[destination]));
    }

    public static int extractMin() {
        int minVal = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i] && costs[i] < minVal) {
                minVal = costs[i];
                idx = i;
            }
        }
        return idx;
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