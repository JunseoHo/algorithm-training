import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static int M;
    static List<List<Integer>> graph;
    static int[] incomingEdges;
    static int[] sorted;
    static boolean[] visited;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
        graph = new LinkedList<>();
        for (int i = 0; i < N; i++) graph.add(new LinkedList<>());
        incomingEdges = new int[N];
        Arrays.fill(incomingEdges, 0);
        sorted = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            vars = br.readLine().split(" ");
            int src = Integer.parseInt(vars[0]) - 1;
            int dst = Integer.parseInt(vars[1]) - 1;
            graph.get(src).add(dst);
            incomingEdges[dst]++;
        }
    }

    public static void solve() throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) if (incomingEdges[i] == 0) queue.add(i);
        int prerequisite = 1;
        int idx = 0;
        while (idx != N) {
            if (!queue.isEmpty()) {
                int i = queue.poll();
                sorted[i] = prerequisite;
                visited[i] = true;
                for (int adj : graph.get(i)) incomingEdges[adj]--;
                idx++;
            } else {
                for (int i = 0; i < N; i++) if (!visited[i] && incomingEdges[i] == 0) queue.add(i);
                prerequisite++;
            }
        }
        for (int i : sorted) bw.write(i + " ");
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