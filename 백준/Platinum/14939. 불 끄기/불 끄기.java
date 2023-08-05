import java.io.*;
import java.util.Arrays;

public class Main {

    static boolean[][] matrix;

    public static void init() throws IOException {
        matrix = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < 10; j++) matrix[i][j] = row[j] == 'O';
        }
    }

    public static void press(int i, int j, boolean subMatrix[][]) {
        if (i > 0) subMatrix[i - 1][j] = !subMatrix[i - 1][j];
        subMatrix[i][j] = !subMatrix[i][j];
        if (i < 9) subMatrix[i + 1][j] = !subMatrix[i + 1][j];
        if (j > 0) subMatrix[i][j - 1] = !subMatrix[i][j - 1];
        if (j < 9) subMatrix[i][j + 1] = !subMatrix[i][j + 1];
    }

    public static boolean check(boolean[][] subMatrix) {
        for (int j = 0; j < 10; j++) {
            if (subMatrix[9][j])
                return true;
        }
        return false;
    }

    public static int find(int init) {
        int answer = 0;
        boolean subMatrix[][] = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) subMatrix[i][j] = matrix[i][j];
        }
        for (int i = 0; i < 10; i++) {
            int shift = (init >> 9 - i) & 1;
            if (shift == 1) {
                press(0, i, subMatrix);
                ++answer;
            }
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (subMatrix[i - 1][j]) {
                    press(i, j, subMatrix);
                    ++answer;
                }
            }
        }
        if (check(subMatrix))
            return -1;
        return answer;
    }

    public static void solve() throws IOException {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 1024; i++) {
            int f = find(i);
            if (f != -1 && f < answer)
                answer = f;
        }
        if (answer == Integer.MAX_VALUE)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(answer));
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
