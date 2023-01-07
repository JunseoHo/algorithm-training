import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            int col = Integer.parseInt(br.readLine());
            stickers = new int[2][col + 1];
            dpTable = new int[2][col + 1];
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < col + 1; k++)
                    stickers[j][k] = 0;
            for (int k = 0; k < col + 1; k++) dpTable[0][k] = 0;
            for (int k = 0; k < col + 1; k++) dpTable[1][k] = 0;
            for (int j = 0; j < 2; j++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int k = 1; k < col + 1; k++)
                    stickers[j][k] = Integer.parseInt(tokenizer.nextToken());
            }
            for (int j = 1; j < col + 1; j++) {
                if (j == 1) {
                    dpTable[0][1] = stickers[0][1];
                    dpTable[1][1] = stickers[1][1];
                } else {
                    dpTable[0][j] = Math.max(Math.max(dpTable[0][j - 2], dpTable[1][j - 2]), dpTable[1][j - 1]) + stickers[0][j];
                    dpTable[1][j] = Math.max(Math.max(dpTable[0][j - 2], dpTable[1][j - 2]), dpTable[0][j - 1]) + stickers[1][j];
                }
            }
            bw.write(Math.max(dpTable[0][col], dpTable[1][col]) + "\n");
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[][] stickers;
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