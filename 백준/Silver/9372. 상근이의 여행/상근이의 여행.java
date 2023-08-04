import java.io.*;
import java.util.*;

public class Main {

    static int T, V, E;
    static List<List<Integer>> graph;
    static boolean visited[];

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        for (int t = 0; t < T; t++) {
            int answer = 0;
            // init
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            V = Integer.parseInt(tokenizer.nextToken());
            E = Integer.parseInt(tokenizer.nextToken());
            graph = new ArrayList<>();
            for (int v = 0; v < V + 1; v++) graph.add(new ArrayList<>());
            visited = new boolean[V + 1];
            for (int e = 0; e < E; e++) {
                tokenizer = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(tokenizer.nextToken());
                int v = Integer.parseInt(tokenizer.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            // solve
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            visited[1] = true;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int adj : graph.get(v)) {
                    if (!visited[adj]) {
                        ++answer;
                        visited[adj] = true;
                        queue.add(adj);
                    }
                }
            }
            bw.write(String.valueOf(answer) + "\n");
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }
}
