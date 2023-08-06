import java.io.*;

public class Main {

    static int T;
    static int K;
    static int pages[];
    static int dpTable[][];

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    public static int solve(int i, int j) {
        if (i == j) return 0;
        if (dpTable[i][j] != -1) return dpTable[i][j];
        if (i + 1 == j) return dpTable[i][j] = pages[i] + pages[j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) min = Math.min(min, solve(i, k) + solve(k + 1, j));
        int last = 0;
        for (int k = i; k <= j; k++) last += pages[k];
        dpTable[i][j] = min + last;
        return dpTable[i][j];
    }

    public static void solve() throws IOException {

        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());
            String[] values = br.readLine().split(" ");
            pages = new int[K];
            for (int k = 0; k < K; k++) pages[k] = Integer.parseInt(values[k]);
            dpTable = new int[K][K];
            for (int i = 0; i < K; i++) for (int j = 0; j < K; j++) dpTable[i][j] = -1;
            bw.write(String.valueOf(solve(0, K - 1)) + "\n");
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
