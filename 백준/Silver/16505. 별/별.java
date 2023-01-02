import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        matrix = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
        for (int i = 0; i < (int) Math.pow(2, N); i++)
            for (int j = 0; j < (int) Math.pow(2, N); j++)
                matrix[i][j] = -1;
    }

    public static void solve() throws IOException {
        printStars(0, 0, N);
        for (int i = 0; i < (int) Math.pow(2, N); i++) {
            for (int j = (int) Math.pow(2, N) - 1; j > -1; j--) {
                if (matrix[i][j] == 0) matrix[i][j] = -1;
                else break;
            }
        }
        for (int i = 0; i < (int) Math.pow(2, N); i++) {
            for (int j = 0; j < (int) Math.pow(2, N); j++) {
                if (matrix[i][j] != -1)
                    bw.write(matrix[i][j] == 1 ? "*" : " ");
            }
            bw.write("\n");
        }
    }

    public static void printStars(int row, int col, int len) {
        if (len == 0) matrix[row][col] = 1;
        else if (len == 1) {
            matrix[row][col] = 1;
            matrix[row][col + 1] = 1;
            matrix[row + 1][col] = 1;
            matrix[row + 1][col + 1] = 0;
        } else {
            printStars(row, col, len - 1);
            printStars(row, (int) (col + Math.pow(2, len - 1)), len - 1);
            printStars((int) (row + Math.pow(2, len - 1)), col, len - 1);
            for (int i = (int) (row + Math.pow(2, len) / 2); i < (int) (row + Math.pow(2, len)); i++) {
                for (int j = (int) (col + Math.pow(2, len) / 2); j < (int) (col + Math.pow(2, len)); j++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[][] matrix;

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