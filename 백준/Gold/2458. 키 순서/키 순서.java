import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static int M;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
        graph = new LinkedList<>();
        for (int i = 0; i < N; i++) graph.add(new LinkedList<>());
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            vars = br.readLine().split(" ");
            int src = Integer.parseInt(vars[0]) - 1;
            int dst = Integer.parseInt(vars[1]) - 1;
            graph.get(src).add(dst);
        }
    }

    public static void solve() throws IOException {
        int answer = 0;
        int[] relation = new int[N];
        Arrays.fill(relation, 0);
        for (int i = 0; i < N; i++) {
            Queue<Integer> que = new LinkedList<>();
            visited = new boolean[N];
            que.add(i);
            visited[i] = true;
            while (!que.isEmpty()) {
                int idx = que.poll();
                for (int adj : graph.get(idx)) {
                    if (!visited[adj]) {
                        que.add(adj);
                        visited[adj] = true;
                        relation[i]++;
                        relation[adj]++;
                    }
                }
            }
        }
        for (int i : relation) if (i >= N - 1) answer++;
        bw.write(String.valueOf(answer));
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