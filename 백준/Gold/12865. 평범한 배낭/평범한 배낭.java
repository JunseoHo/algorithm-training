import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        weight = new int[N + 1];
        price = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            input = br.readLine().split(" ");
            weight[i] = Integer.parseInt(input[0]);
            price[i] = Integer.parseInt(input[1]);
        }
        dpTable = new int[N + 1][K + 1];
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(pack()));
    }

    public static int pack() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (weight[i] <= j)
                    dpTable[i][j] = Math.max(price[i] + dpTable[i - 1][j - weight[i]], dpTable[i - 1][j]);
                else
                    dpTable[i][j] = dpTable[i - 1][j];
            }
        }
        return dpTable[N][K];
    }


    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int K;
    static int[] weight;
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