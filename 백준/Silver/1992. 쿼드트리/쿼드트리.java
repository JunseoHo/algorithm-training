import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++)
                video[i][j] = Integer.parseInt(row[j]);
        }
    }

    public static void solve() throws IOException {
        bw.write(compress(0, 0, N));
    }

    public static String compress(int row, int col, int len) {
        int sum = 0;
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++)
                sum += video[i][j];
        }
        if (sum == 0) return "0";
        else if (sum == len * len) return "1";
        else {
            String leftTop = compress(row, col, len / 2);
            String rightTop = compress(row, col + len / 2, len / 2);
            String leftBottom = compress(row + len / 2, col, len / 2);
            String rightBottom = compress(row + len / 2, col + len / 2, len / 2);
            return "(" + leftTop + rightTop + leftBottom + rightBottom + ")";
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[][] video;
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