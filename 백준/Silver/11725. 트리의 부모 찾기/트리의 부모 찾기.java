import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        visited = new boolean[N];
        parent = new int[N];
        for (int i = 0; i < N - 1; i++) {
            String[] vars = br.readLine().split(" ");
            int src = Integer.parseInt(vars[0]) - 1;
            int dst = Integer.parseInt(vars[1]) - 1;
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
    }

    public static void solve() throws IOException {
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = true;
        while (!que.isEmpty()) {
            int idx = que.poll();
            for (int adj : graph.get(idx)) {
                if (!visited[adj]) {
                    parent[adj] = idx + 1;
                    visited[adj] = true;
                    que.add(adj);
                }
            }
        }
        for (int i = 1; i < N; i++) bw.write(parent[i] + "\n");
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }

}