import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N, M;
    static List<List<Integer>> graph;
    static int[] incomingEdges;
    static PriorityQueue<int[]> queue;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        M = Integer.parseInt(values[1]);
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
        incomingEdges = new int[N + 1];
        for (int i = 0; i < M; i++) {
            values = br.readLine().split(" ");
            int src = Integer.parseInt(values[0]);
            int dst = Integer.parseInt(values[1]);
            graph.get(src).add(dst);
            incomingEdges[dst]++;
        }
        queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] < o2[1]) return -1;
            else if (o1[1] > o2[1]) return 1;
            else {
                if (o1[0] < o2[0]) return -1;
                else if (o1[0] > o2[0]) return 1;
                return 0;
            }
        });
    }

    public static void solve() throws IOException {
        while (true) {
            for (int i = 1; i < N + 1; i++)
                if (incomingEdges[i] == 0) {
                    --incomingEdges[i];
                    queue.add(new int[]{i, 0});
                    break;
                }
            if (queue.isEmpty()) break;
            while (!queue.isEmpty()) {
                int idx = queue.poll()[0];
                for (int adj : graph.get(idx)) --incomingEdges[adj];
                bw.write(idx + " ");
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