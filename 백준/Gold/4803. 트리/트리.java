import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static int m;
    static int[] p;
    static List<List<Integer>> graph;
    static boolean visited[];


    public static void init() throws IOException {

    }

    public static void union(int u, int v) {
        p[find(u)] = find(v);
    }

    public static int find(int v) {
        if (p[v] == v) return v;
        p[v] = find(p[v]);
        return p[v];
    }

    public static void solve() throws IOException {
        List<Integer> answers = new ArrayList<>();
        while (true) {
            // init
            String[] values = br.readLine().split(" ");
            n = Integer.parseInt(values[0]);
            m = Integer.parseInt(values[1]);
            if (n == 0 && m == 0) break;
            p = new int[n + 1];
            for (int i = 1; i < n + 1; i++) p[i] = i;
            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                values = br.readLine().split(" ");
                int s = Integer.parseInt(values[0]);
                int d = Integer.parseInt(values[1]);
                graph.get(s).add(d);
            }
            visited = new boolean[n + 1];
            // solve
            for (int i = 1; i < n + 1; i++) {
                for (int adj : graph.get(i)) {
                    if (find(i) != find(adj)) {
                        if (find(i) == 0)
                            union(adj, 0);
                        else if (find(adj) == 0)
                            union(i, 0);
                        else
                            union(i, adj);
                    } else {
                        union(i, 0);
                    }
                }
            }
            // print
            int T = 0;
            for (int i = 1; i < n + 1; i++) {
                visited[find(i)] = true;
            }
            for (int i = 1; i < n + 1; i++) {
                if (visited[i]) ++T;
            }
            answers.add(T);
        }
        for (int i = 0; i < answers.size(); i++) {
            int t = answers.get(i);
            if (t == 0) bw.write("Case " + (i + 1) + ": " + "No trees.\n");
            else if (t == 1) bw.write("Case " + (i + 1) + ": " + "There is one tree.\n");
            else bw.write("Case " + (i + 1) + ": " + "A forest of " + t + " trees.\n");
        }

    }


    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        solve();
        close();
    }

}
