import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dpTable = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(tokenizer.nextToken());
                if (i == 0 && j == 0) dpTable[i][j] = n;
                else if (i == 0 && j != 0) dpTable[i][j] = dpTable[i][j - 1] + n;
                else if (i != 0 && j == 0) dpTable[i][j] = dpTable[i - 1][j] + n;
                else
                    dpTable[i][j] =
                            Math.max(Math.max(dpTable[i - 1][j - 1], dpTable[i - 1][j]), dpTable[i][j - 1]) + n;
            }
        }
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(dpTable[N - 1][M - 1]));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int M;
    static int[][] dpTable;

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