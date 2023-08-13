import java.io.*;

public class Main {

    static int n, m;
    static int p[];

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        n = Integer.parseInt(values[0]);
        m = Integer.parseInt(values[1]);
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
    }

    public static int find(int i) {
        if (p[i] == i) return i;
        p[i] = find(p[i]);
        return p[i];
    }

    public static void union(int i, int j) {
        p[find(i)] = p[find(j)];
    }

    public static void solve() throws IOException {
        int cycle = 0;
        for (int turn = 1; turn < m + 1; turn++) {
            String[] values = br.readLine().split(" ");
            int i = Integer.parseInt(values[0]);
            int j = Integer.parseInt(values[1]);
            if (find(i) == find(j) && cycle == 0) cycle = turn;
            union(i, j);
        }
        bw.write(String.valueOf(cycle));
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
