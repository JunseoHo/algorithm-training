import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        dpTable = new long[10][N + 1];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < N + 1; j++)
                dpTable[i][j] = -1;
    }

    public static void solve() throws IOException {
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += findAscendingNumbers(i, N) % 10007;
            answer %= 10007;
        }
        bw.write(String.valueOf(answer));
    }

    public static long findAscendingNumbers(int x, int n) {
        if (dpTable[x][n] != -1) return dpTable[x][n];
        if (n == 1) dpTable[x][n] = 1;
        else {
            int val = 0;
            for (int i = x; i < 10; i++)
                val += findAscendingNumbers(i, n - 1) % 10007;
            dpTable[x][n] = val;
        }
        return dpTable[x][n];
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static long[][] dpTable;

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