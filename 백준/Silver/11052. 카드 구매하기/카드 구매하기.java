import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        price = new int[N + 1];
        dpTable = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < N + 1; j++)
                dpTable[i][j] = 0;
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            price[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static void solve() throws IOException {
        for (int p = 1; p < N + 1; p++) {
            for (int w = 1; w < N + 1; w++) {
                if (p > w) dpTable[p][w] = dpTable[p - 1][w];
                else {
                    int max = 0;
                    int count = 1;
                    while (w - (p * count) >= 0) {
                        max = Math.max(dpTable[p - 1][w - (p * count)] + (price[p] * count), max);
                        max = Math.max(dpTable[p - 1][w], max);
                        count++;
                    }
                    dpTable[p][w] = max;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++)
                max = Math.max(dpTable[i][j], max);
        }
        bw.write(String.valueOf(max));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[] price;
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