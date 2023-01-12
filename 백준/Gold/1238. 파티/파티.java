import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]) - 1;
        graph = new LinkedList<>();
        for (int i = 0; i < N; i++) graph.add(new LinkedList<>());
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int source = Integer.parseInt(input[0]) - 1;
            int destin = Integer.parseInt(input[1]) - 1;
            int weight = Integer.parseInt(input[2]);
            graph.get(source).add(new int[]{destin, weight});
        }
        distance = new int[N];
        visited = new boolean[N];
        answer = new int[N];
    }

    public static void solve() throws IOException {
        for (int start = 0; start < N; start++) {
            Arrays.fill(distance, Integer.MAX_VALUE); // init distance
            Arrays.fill(visited, false);
            distance[start] = 0;
            visitedCount = 0;
            while (visitedCount < N) {
                int v = extractMin();
                visited[v] = true;
                for (int[] adj : graph.get(v)) {
                    int u = adj[0];
                    int w = adj[1]; // weight
                    if (!visited[u] && distance[v] + w < distance[u])
                        distance[u] = distance[v] + w;
                }
                visitedCount++;
            }
            answer[start] += distance[X];
            if (start == X) for (int i = 0; i < N; i++) answer[i] += distance[i];
        }
        int max = Integer.MIN_VALUE;
        for (int d : answer) max = Math.max(max, d);
        bw.write(String.valueOf(max));
    }

    public static int extractMin() {
        int min = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i < N; i++)
            if (distance[i] < min && !visited[i]) {
                min = distance[i];
                v = i;
            }
        return v;
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int M;
    static int X;
    static List<List<int[]>> graph;
    static int[] distance;
    static boolean[] visited;
    static int visitedCount;
    static int[] answer;

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