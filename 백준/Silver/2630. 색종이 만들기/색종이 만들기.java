import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void solve() throws IOException {
        for (int r : cut(0, 0, N)) bw.write(r + "\n");
    }

    public static int[] cut(int row, int col, int len) {
        int sum = 0;
        for (int i = row; i < row + len; i++)
            for (int j = col; j < col + len; j++) sum += matrix[i][j];
        if (sum == 0) return new int[]{1, 0};
        if (sum == len * len) return new int[]{0, 1};
        int[] i = cut(row, col, len / 2);
        int[] ii = cut(row, col + len / 2, len / 2);
        int[] iii = cut(row + len / 2, col, len / 2);
        int[] iv = cut(row + len / 2, col + len / 2, len / 2);
        return new int[]{i[0] + ii[0] + iii[0] + iv[0], i[1] + ii[1] + iii[1] + iv[1]};
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int matrix[][];

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