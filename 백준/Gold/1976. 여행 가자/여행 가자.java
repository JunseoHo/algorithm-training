import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] set;
    static int[] path;

    public static int find(int i) {
        if (set[i] == i) return i;
        set[i] = find(set[i]);
        return set[i];
    }

    public static void union(int i, int j) {
        set[find(i)] = set[find(j)];
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        set = new int[N];
        for (int i = 0; i < N; i++) set[i] = i;
        for (int i = 0; i < N; i++) {
            String[] values = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(values[j]) == 1) {
                    union(i, j);
                }
            }
        }
        path = new int[M];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < M; i++) path[i] = Integer.parseInt(values[i]) - 1;
    }

    public static void solve() throws IOException {
        for (int i = 0; i < M - 1; i++) {
            if (find(path[i]) != find(path[i + 1])) {
                bw.write("NO");
                return;
            }
        }
        bw.write("YES");
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
