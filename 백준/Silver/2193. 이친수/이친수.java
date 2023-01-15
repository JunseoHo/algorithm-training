import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static long[][] dpTable;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        dpTable = new long[2][N + 1];
    }

    public static void solve() throws IOException {
        dpTable[0][0] = 0;
        dpTable[1][0] = 0;
        dpTable[0][1] = 0;
        dpTable[1][1] = 1;
        if (N > 1) {
            for (int i = 2; i < N + 1; i++) {
                dpTable[0][i] = dpTable[0][i - 1] + dpTable[1][i - 1];
                dpTable[1][i] = dpTable[0][i - 1];
            }
        }
        bw.write(String.valueOf(dpTable[0][N] + dpTable[1][N]));
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
