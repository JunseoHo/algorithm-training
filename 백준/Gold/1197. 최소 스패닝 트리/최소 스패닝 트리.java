import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static List<List<int[]>> graph;
    static PriorityQueue<int[]> edges;
    static boolean[] visited;


    public static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        V = Integer.parseInt(tokenizer.nextToken());
        E = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[V + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            graph.get(s).add(new int[]{d, w});
            graph.get(d).add(new int[]{s, w});
        }
        edges = new PriorityQueue<int[]>((o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] < o2[1]) return -1;
            else return 0;
        });
    }

    public static void solve() throws IOException {
        int weight = 0;
        edges.add(new int[]{1, 0});
        while (!edges.isEmpty()) {
            int[] vertex = edges.poll();
            if (visited[vertex[0]]) continue;
            visited[vertex[0]] = true;
            weight += vertex[1];
            for (int[] adj : graph.get(vertex[0])) {
                if (!visited[adj[0]]) {
                    edges.add(adj);
                }
            }
        }
        bw.write(String.valueOf(weight));
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
