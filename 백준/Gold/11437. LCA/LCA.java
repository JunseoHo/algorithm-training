import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new LinkedList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new LinkedList<>());
        parent = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            String[] vars = br.readLine().split(" ");
            int p = Integer.parseInt(vars[0]);
            int c = Integer.parseInt(vars[1]);
            graph.get(p).add(c);
            graph.get(c).add(p);
        }
        visited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = true;
        while (!que.isEmpty()) {
            int idx = que.poll();
            for (int adj : graph.get(idx)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    que.add(adj);
                    parent[adj] = idx;
                }
            }
        }
    }

    public static void solve() throws IOException {
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean[] isParent = new boolean[N + 1];
            String[] vars = br.readLine().split(" ");
            int a = Integer.parseInt(vars[0]);
            int b = Integer.parseInt(vars[1]);
            isParent[a] = true;
            while (a != 1) {
                a = parent[a];
                isParent[a] = true;
            }
            if (isParent[b]) bw.write(b + "\n");
            else {
                while (b != 1) {
                    b = parent[b];
                    if (isParent[b]) {
                        bw.write(b + "\n");
                        break;
                    }
                }
            }
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