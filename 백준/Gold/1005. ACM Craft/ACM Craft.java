import java.io.*;
import java.util.*;

public class Main {
    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        long[] answer = new long[T];
        for (int t = 0; t < T; t++) {
            // init variables
            String[] vars = br.readLine().split(" ");
            int N = Integer.parseInt(vars[0]);
            int K = Integer.parseInt(vars[1]);

            vars = br.readLine().split(" ");
            int[] buildTime = new int[N];
            long[] minimumTime = new long[N];
            for (int i = 0; i < N; i++) {
                buildTime[i] = Integer.parseInt(vars[i]);
                minimumTime[i] = buildTime[i];
            }

            int[] inDegree = new int[N];
            Arrays.fill(inDegree, 0);

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < K; i++) {
                vars = br.readLine().split(" ");
                int src = Integer.parseInt(vars[0]) - 1;
                int dst = Integer.parseInt(vars[1]) - 1;
                graph.get(src).add(dst);
                inDegree[dst]++;
            }

            int W = Integer.parseInt(br.readLine()) - 1;

            Queue<Integer> que = new LinkedList<>();
            for (int i = 0; i < N; i++) if (inDegree[i] == 0) que.add(i);
            while (!que.isEmpty()) {
                int idx = que.poll();
                for (int adj : graph.get(idx)) {
                    minimumTime[adj] = Math.max(minimumTime[adj], minimumTime[idx] + buildTime[adj]);
                    if (--inDegree[adj] == 0) que.add(adj);
                }
            }
            answer[t] = minimumTime[W];
        }
        for (long t : answer) System.out.println(t);
    }
}