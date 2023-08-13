import java.io.*;

public class Main {

    static int N, M;
    static int numbers[];
    static int DP[][];

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(values[i]);
        M = Integer.parseInt(br.readLine());
        DP = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) DP[i][j] = -1;
    }

    public static int solve(int i, int j) {
        if (i == j) return 1;
        if (DP[i][j] != -1) return DP[i][j];
        if (i + 1 == j) {
            DP[i][j] = numbers[i] == numbers[j] ? 1 : 0;
            return DP[i][j];
        } else {
            if (numbers[i] == numbers[j]) {
                DP[i][j] = solve(i + 1, j - 1);
                return DP[i][j];
            }
            DP[i][j] = 0;
            return DP[i][j];
        }
    }

    public static void solve() throws IOException {
        for (int m = 0; m < M; m++) {
            String values[] = br.readLine().split(" ");
            int i = Integer.parseInt(values[0]) - 1;
            int j = Integer.parseInt(values[1]) - 1;
            if (solve(i, j) == 1) bw.write("1\n");
            else bw.write("0\n");
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
