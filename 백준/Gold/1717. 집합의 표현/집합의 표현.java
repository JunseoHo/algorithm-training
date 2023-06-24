import java.io.*;
import java.util.Arrays;

public class Main {

    static int n, m;
    static int[] sets;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        n = Integer.parseInt(values[0]);
        m = Integer.parseInt(values[1]);
        sets = new int[n + 1];
        for (int i = 0; i < n + 1; i++) sets[i] = i;
    }

    public static int find(int u) {
        if (u == sets[u])
            return u;
        else
            return find(sets[u]);
    }

    public static void solve() throws IOException {
        for (int i = 0; i < m; i++) {
            String[] values = br.readLine().split(" ");
            int u = Integer.parseInt(values[1]);
            int v = Integer.parseInt(values[2]);
            if (values[0].equals("0")) {
                sets[find(v)] = find(u);
            } else {
                if (find(u) == find(v))
                    bw.write("YES\n");
                else
                    bw.write("NO\n");
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

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }
}