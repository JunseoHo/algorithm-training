import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static List<List<Integer>> tree;
    static Integer[][] dpTable;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) tree.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            String[] relation = br.readLine().split(" ");
            int a = Integer.parseInt(relation[0]) - 1;
            int b = Integer.parseInt(relation[1]) - 1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dpTable = new Integer[N][2];
        for (int i = 0; i < N; i++) for (int j = 0; j < 2; j++) dpTable[i][j] = null;
    }

    public static int solve(int parent, int node, boolean isEarlyAdapter) {
        if (dpTable[node][isEarlyAdapter ? 1 : 0] != null)
            return dpTable[node][isEarlyAdapter ? 1 : 0];
        if (isEarlyAdapter) {
            int result = 1;
            for (int child : tree.get(node)) {
                if (parent != child)
                    result += Math.min(solve(node, child, false), solve(node, child, true));
            }
            dpTable[node][1] = result;
        } else {
            int result = 0;
            for (int child : tree.get(node)) {
                if (parent != child)
                    result += solve(node, child, true);
            }
            dpTable[node][0] = result;
        }
        return dpTable[node][isEarlyAdapter ? 1 : 0];
    }

    public static void solve() throws IOException {
        int resultA = solve(-1, 0, true);
        int resultB = solve(-1, 0, false);
        System.out.println(Math.min(resultA, resultB));
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