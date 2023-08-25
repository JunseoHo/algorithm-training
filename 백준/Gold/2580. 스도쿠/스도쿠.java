import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int[][] sudoku;

    public static void init() throws IOException {
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] values = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(values[j]);
            }
        }
    }

    public static boolean checkRow(int i, int n) {
        for (int j = 0; j < 9; j++) {
            if (sudoku[i][j] == n) return true;
        }
        return false;
    }

    public static boolean checkCol(int j, int n) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][j] == n) return true;
        }
        return false;
    }

    public static boolean checkSquare(int i, int j, int n) {
        while (i % 3 != 0) --i;
        while (j % 3 != 0) --j;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++){
                if (sudoku[k][l] == n) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean play(int i, int j) {
        if (i == 9) return true;
        if (j == 9) return play(i + 1, 0);
        if (sudoku[i][j] != 0) return play(i, j + 1);
        for (int n = 1; n < 10; n++) {
            if (!checkRow(i, n) && !checkCol(j, n) && !checkSquare(i, j, n)) {
                sudoku[i][j] = n;
                if (play(i, j + 1)) return true;
                sudoku[i][j] = 0;
            }
        }
        return false;
    }

    public static void solve() throws IOException {
        play(0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(String.valueOf(sudoku[i][j]) + " ");
            }
            bw.write("\n");
        }
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