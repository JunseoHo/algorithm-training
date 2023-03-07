import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int M;
    static List<List<Integer>> graph;
    static int[] distance;
    static boolean[] visited;
    static int[] numOfBacon;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        M = Integer.parseInt(values[1]);
        numOfBacon = new int[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(numOfBacon, 0);
        Arrays.fill(distance, Integer.MAX_VALUE);
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            values = br.readLine().split(" ");
            int src = Integer.parseInt(values[0]);
            int dst = Integer.parseInt(values[1]);
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
    }

    public static void solve() throws IOException {
        for (int start = 1; start < N + 1; start++) {
            Arrays.fill(distance, Integer.MAX_VALUE);
            Arrays.fill(visited, false);
            distance[start] = 0;
            for (int i = 1; i < N; i++) {
                int idx = extractMin();
                visited[idx] = true;
                for (int adj : graph.get(idx)) {
                    if (!visited[adj] && distance[adj] > distance[idx] + 1) {
                        distance[adj] = distance[idx] + 1;
                    }
                }
            }
            int bacon = 0;
            for (int i = 1; i < N + 1; i++)
                bacon += distance[i];
            numOfBacon[start] = bacon;
        }
        int value = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i < N + 1; i++) {
            if (value > numOfBacon[i]) {
                idx = i;
                value = numOfBacon[i];
            }
        }
        bw.write(String.valueOf(idx));
    }

    public static int extractMin() {
        int value = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i < N + 1; i++) {
            if (value > distance[i] && !visited[i]) {
                idx = i;
                value = distance[i];
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