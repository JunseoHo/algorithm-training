import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] coins;
    static int[][] dpTable;

    public static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        coins = new int[n + 1];
        for (int i = 1; i < n + 1; i++) coins[i] = Integer.parseInt(br.readLine());
        dpTable = new int[n + 1][k + 1];
        for (int i = 0; i < k + 1; i++) dpTable[0][i] = -1;
        for (int i = 0; i < n + 1; i++) dpTable[i][0] = -1;
    }

    public static void solve() throws IOException {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (coins[i] > j) dpTable[i][j] = dpTable[i - 1][j];
                else {
                    int price = j - coins[i];
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k <= i; k++)
                        if (dpTable[k][price] != -1) min = Math.min(min, dpTable[k][price]);
                    if (min == Integer.MAX_VALUE) {
                        if (j % coins[i] == 0) dpTable[i][j] = j / coins[i];
                        else dpTable[i][j] = -1;
                    } else dpTable[i][j] = min + 1;
                }
            }
            if (dpTable[i][k] != -1) answer = Math.min(answer, dpTable[i][k]);
        }
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < k + 1; j++) {
//                System.out.printf("%3d ", dpTable[i][j]);
//            }
//            System.out.println();
//        }
        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));
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
