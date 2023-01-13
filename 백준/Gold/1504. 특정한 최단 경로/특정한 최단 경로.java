import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        E = Integer.parseInt(vars[1]);
        graph = new LinkedList<>();
        for (int i = 0; i < N; i++) graph.add(new LinkedList<>());
        for (int i = 0; i < E; i++) {
            vars = br.readLine().split(" ");
            int src = Integer.parseInt(vars[0]) - 1;
            int dst = Integer.parseInt(vars[1]) - 1;
            int w = Integer.parseInt(vars[2]);
            graph.get(src).add(new int[]{dst, w});
            graph.get(dst).add(new int[]{src, w});
        }
        vars = br.readLine().split(" ");
        V1 = Integer.parseInt(vars[0]) - 1;
        V2 = Integer.parseInt(vars[1]) - 1;
        distanceFromZero = new int[N];
        Arrays.fill(distanceFromZero, INF);
        distanceFromV1 = new int[N];
        Arrays.fill(distanceFromV1, INF);
        distanceFromV2 = new int[N];
        Arrays.fill(distanceFromV2, INF);
        visited = new boolean[N];
    }

    public static void solve() throws IOException {
        dijkstra(0, distanceFromZero);
        dijkstra(V1, distanceFromV1);
        dijkstra(V2, distanceFromV2);
        int pathV1 = distanceFromZero[V1] == INF || distanceFromV1[V2] == INF || distanceFromV2[N - 1] == INF ?
                -1 : distanceFromZero[V1] + distanceFromV1[V2] + distanceFromV2[N - 1];
        int pathV2 = distanceFromZero[V2] == INF || distanceFromV2[V1] == INF || distanceFromV1[N - 1] == INF ?
                -1 : distanceFromZero[V2] + distanceFromV2[V1] + distanceFromV1[N - 1];
        bw.write(String.valueOf(Math.min(pathV1, pathV2)));
    }

    public static void dijkstra(int start, int[] distance) {
        visited = new boolean[N];
        distance[start] = 0;
        for (int i = 0; i < N - 1; i++) {
            int v = extractMin(distance);
            visited[v] = true;
            for (int[] adj : graph.get(v)) {
                int u = adj[0];
                int w = adj[1];
                if (!visited[u] && distance[v] + w < distance[u]) {
                    distance[u] = distance[v] + w;
                }
            }
        }
    }

    public static int extractMin(int[] distance) {
        int v = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && distance[i] < minVal) {
                v = i;
                minVal = distance[i];
            }
        }
        return v;
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int E;
    static int V1;
    static int V2;
    static List<List<int[]>> graph;
    static int[] distanceFromZero;
    static int[] distanceFromV1;
    static int[] distanceFromV2;
    static boolean[] visited;
    static final int INF = 200000000;

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