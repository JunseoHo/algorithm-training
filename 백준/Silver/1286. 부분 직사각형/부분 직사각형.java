import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int M;
    static char[][] rect;
    static long[] numOfAlpha;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        M = Integer.parseInt(values[1]);
        rect = new char[N][M];
        for (int r = 0; r < N; r++) {
            char[] arr = br.readLine().toCharArray();
            for (int c = 0; c < M; c++) rect[r][c] = arr[c];
        }
        numOfAlpha = new long[26];
        Arrays.fill(numOfAlpha, 0);
    }

    public static void solve() throws IOException {
        for (int r = 0; r < N * 2; r++) {
            for (int c = 0; c < M * 2; c++) {
                int size = ((N * 2) - r) * ((M * 2) - c);
                int count = size * ((r + 1) * (c + 1));
                int block_r = r >= N ? r - N : r;
                int block_c = c >= M ? c - M : c;
                numOfAlpha[rect[block_r][block_c] - 65] += count;
            }
        }
        for (long num : numOfAlpha) bw.write(num + "\n");
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