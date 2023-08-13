import java.io.*;

public class Main {

    static char[][] sudoku;

    public static void init() throws IOException {
        sudoku = new char[9][9];
        for (int i = 0; i < 9; i++) sudoku[i] = br.readLine().toCharArray();
    }

    public static boolean check(int row, int col, char c) {
        for (int i = 0; i < 9; i++) if (sudoku[row][i] == c) return false;
        for (int i = 0; i < 9; i++) if (sudoku[i][col] == c) return false;
        while (row % 3 != 0) --row;
        while (col % 3 != 0) --col;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) if (sudoku[row + i][col + j] == c) return false;
        return true;
    }

    public static boolean solve(int i, int j) {
        if (i == 9) return true;
        if (j == 9) return solve(i + 1, 0);
        if (sudoku[i][j] != '0') return solve(i, j + 1);
        for (char c = '1'; c <= '9'; c++) {
            if (check(i, j, c)) {
                sudoku[i][j] = c;
                if (solve(i, j + 1)) return true;
                sudoku[i][j] = '0';
            }
        }
        return false;
    }

    public static void solve() throws IOException {
        solve(0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) bw.write(sudoku[i][j]);
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

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }
}
