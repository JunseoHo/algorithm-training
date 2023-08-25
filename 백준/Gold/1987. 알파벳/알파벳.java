import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int R, C;
    static char[][] matrix;
    static int[][] dpTable;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        R = Integer.parseInt(values[0]);
        C = Integer.parseInt(values[1]);
        matrix = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) matrix[i][j] = arr[j];
        }
        dpTable = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) dpTable[i][j] = 0;
        }
    }

    public static int solve(int r, int c, int dist, int stat) {
        if (r < 0 || r > R - 1 || c < 0 || c > C - 1) return 0;
        int order = matrix[r][c] - 'A';
        if (((stat >> order) & 1) == 1) return dist;
        if (dpTable[r][c] < dist) dpTable[r][c] = dist;
        stat |= 1 << matrix[r][c] - 'A';
        int up = solve(r - 1, c, dist + 1, stat);
        int down = solve(r + 1, c, dist + 1, stat);
        int left = solve(r, c - 1, dist + 1, stat);
        int right = solve(r, c + 1, dist + 1, stat);
        return Math.max(up, Math.max(down, Math.max(left, right)));
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(solve(0, 0, 0, 0)));
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) System.out.print(dpTable[i][j] + " ");
//            System.out.println();
//        }
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