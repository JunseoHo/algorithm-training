import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static int E;
    static int src;
    static List<List<int[]>> graph;
    static boolean[] visited;
    static int[] distance;
    static PriorityQueue<int[]> queue;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        V = Integer.parseInt(values[0]);
        E = Integer.parseInt(values[1]);
        src = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            graph.get(u).add(new int[]{v, w});
        }
        visited = new boolean[V + 1];
        Arrays.fill(visited, false);
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return 1;
                else if (o1[1] < o2[1]) return -1;
                else return 0;
            }
        });
    }

    public static void solve() throws IOException {
        distance[src] = 0;
        queue.add(new int[]{src, 0});
        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            if (visited[u[0]]) continue;
            visited[u[0]] = true;
            for (int[] adjacent : graph.get(u[0])) {
                if (distance[adjacent[0]] > distance[u[0]] + adjacent[1]) {
                    distance[adjacent[0]] = distance[u[0]] + adjacent[1];
                    queue.add(new int[]{adjacent[0], distance[adjacent[0]]});
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < distance.length; i++)
            builder.append((distance[i] == 2147483647 ? "INF" : String.valueOf(distance[i])) + "\n");
        bw.write(builder.toString());
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
