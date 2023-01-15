import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static int M;
    static int[] incomingEdges;
    static List<List<Integer>> graph;
    static int[] sort;
    static boolean[] visited;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
        incomingEdges = new int[N];
        Arrays.fill(incomingEdges, 0);
        graph = new LinkedList<>();
        for (int i = 0; i < N; i++) graph.add(new LinkedList<>());
        for (int i = 0; i < M; i++) {
            vars = br.readLine().split(" ");
            int src = Integer.parseInt(vars[0]) - 1;
            int dst = Integer.parseInt(vars[1]) - 1;
            graph.get(src).add(dst);
            incomingEdges[dst]++;
        }
        sort = new int[N];
        visited = new boolean[N];
    }

    public static void solve() throws IOException {
        Queue<Integer> zeroInDegrees = new LinkedList<>();
        for (int i = 0; i < N; i++) if (incomingEdges[i] == 0) zeroInDegrees.add(i);
        for (int i = 0; i < N; i++) {
            int idx = zeroInDegrees.poll();
            sort[i] = idx + 1;
            visited[idx] = true;
            for (int adj : graph.get(idx))
                if (--incomingEdges[adj] == 0 && !visited[adj]) zeroInDegrees.add(adj);
        }
        for (int i : sort) bw.write(i + " ");
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