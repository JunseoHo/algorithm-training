import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        numbers = new int[N + 1];
        dpTable = new int[N + 1][K + 1];
        numbers[0] = 0;
        for (int i = 1; i < N + 1; i++) numbers[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < K + 1; j++) dpTable[i][j] = j == 0 ? 1 : 0;
    }

    public static void solve() throws IOException {
        for (int i = 1; i < N + 1; i++) {
            int coin = numbers[i];
            for (int j = 1; j < K + 1; j++) {
                int count = 0;
                int totalPrice = j;
                while (totalPrice - coin >= 0) {
                    totalPrice -= coin;
                    count += dpTable[i - 1][totalPrice];
                }
                dpTable[i][j] = dpTable[i - 1][j] + count;
            }
        }
        bw.write(String.valueOf(dpTable[N][K]));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int K;
    static int[] numbers;
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