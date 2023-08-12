import java.io.*;

public class Main {

    static int N;
    static int[][] board;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] values = br.readLine().split(" ");
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(values[j]);
            // 0 = Blocked, 1 = Empty, 2 = Bishop
        }
    }

    public static boolean validateLeftTop(int i, int j) {
        --i;
        --j;
        while (i > -1 && j > -1 && i < N && j < N) {
            if (board[i][j] == 2) return false;
            --i;
            --j;
        }
        return true;
    }

    public static boolean validateRightTop(int i, int j) {
        --i;
        ++j;
        while (i > -1 && j > -1 && i < N && j < N) {
            if (board[i][j] == 2) return false;
            --i;
            ++j;
        }
        return true;
    }

    public static boolean validateRightBottom(int i, int j) {
        ++i;
        ++j;
        while (i > -1 && j > -1 && i < N && j < N) {
            if (board[i][j] == 2) return false;
            ++i;
            ++j;
        }
        return true;
    }

    public static boolean validateLeftBottom(int i, int j) {
        ++i;
        --j;
        while (i > -1 && j > -1 && i < N && j < N) {
            if (board[i][j] == 2) return false;
            ++i;
            --j;
        }
        return true;
    }

    public static int solve(int i, int j) {
        if (i == N) return 0;
        if (j == N) return solve(i + 1, N % 2 == 0 ? 1 : 0);
        if (j == N + 1) return solve(i + 1, N % 2 == 0 ? 0 : 1);
        if (board[i][j] == 0) return solve(i, j + 2);
        if (validateLeftTop(i, j)
                && validateRightTop(i, j)
                && validateLeftBottom(i, j)
                && validateRightBottom(i, j)) {
            board[i][j] = 2;
            int count = 1 + solve(i, j + 2);
            board[i][j] = 1;
            count = Math.max(count, solve(i, j + 2));
            return count;
        } else return solve(i, j + 2);
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(solve(0, 0) + solve(0, 1)));
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
