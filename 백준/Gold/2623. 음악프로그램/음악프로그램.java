import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static int M;
    static List<List<Integer>> graph;
    static int[] inDegree;
    static boolean[] visited;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());
        inDegree = new int[N + 1];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            Integer prev = null;
            tokenizer.nextToken();
            while (tokenizer.hasMoreTokens()) {
                int next = Integer.parseInt(tokenizer.nextToken());
                if (prev != null) {
                    graph.get(prev).add(next);
                    inDegree[next]++;
                }
                prev = next;
            }
        }
        visited = new boolean[N + 1];
    }

    public static void solve() throws IOException {
        List<Integer> answer = new LinkedList<>();
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i < N + 1; i++)
            if (inDegree[i] == 0) {
                que.add(i);
                visited[i] = true;
            }
        while (!que.isEmpty()) {
            int idx = que.poll();
            answer.add(idx);
            for (int adj : graph.get(idx)) {
                if (!visited[adj] && --inDegree[adj] == 0) {
                    que.add(adj);
                    visited[adj] = true;
                }
            }
        }
        for (int i = 1; i < N + 1; i++)
            if (!visited[i]) {
                bw.write(String.valueOf(0));
                return;
            }
        for (int i : answer) bw.write(i + "\n");
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