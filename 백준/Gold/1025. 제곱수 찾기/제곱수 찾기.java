import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int M;
    static int[][] matrix;
    static int max;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        M = Integer.parseInt(values[1]);
        matrix = new int[N][M];
        for (int r = 0; r < N; r++) {
            values = br.readLine().split("");
            for (int c = 0; c < M; c++) {
                matrix[r][c] = Integer.parseInt(values[c]);
            }
        }
        max = -1;
    }

    public static boolean isPower(int n) {
        int i = 0;
        while (i * i <= n) {
            if (i * i == n)
                return true;
            ++i;
        }
        return false;
    }

    public static void find(int r, int c, int d1, int d2, int direction, int sum) {
        if (r < 0 || r > N - 1 || c < 0 || c > M - 1)
            return;
        sum = sum * 10 + matrix[r][c];
        if (isPower(sum) && sum > max)
            max = sum;
        if (direction == 0)
            find(r - d1, c, d1, d2, 0, sum);
        if (direction == 1)
            find(r - d1, c + d2, d1, d2, 1, sum);
        if (direction == 2)
            find(r, c + d2, d1, d2, 2, sum);
        if (direction == 3)
            find(r + d1, c + d2, d1, d2, 3, sum);
        if (direction == 4)
            find(r + d1, c, d1, d2, 4, sum);
        if (direction == 5)
            find(r + d1, c - d2, d1, d2, 5, sum);
        if (direction == 6)
            find(r, c - d2, d1, d2, 6, sum);
        if (direction == 7)
            find(r - d1, c - d2, d1, d2, 7, sum);
    }

    public static void solve() throws IOException {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int direction = 0; direction < 8; direction++) {
                    for (int d1 = 1; d1 <= N; d1++) {
                        for (int d2 = 1; d2 <= M; d2++) {
                            find(r, c, d1, d2, direction, 0);
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(max));
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