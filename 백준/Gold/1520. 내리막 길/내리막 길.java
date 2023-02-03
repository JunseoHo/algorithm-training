import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int M;
    static int N;
    static int[][] matrix;
    static int[][] path;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        M = Integer.parseInt(vars[0]);
        N = Integer.parseInt(vars[1]);
        matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        path = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                path[i][j] = -1;
            }
        }
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(findPath(0, 0)));
    }

    public static int findPath(int r, int c) {
        if (r == M - 1 && c == N - 1) return 1;
        if (path[r][c] != -1) return path[r][c];
        int res = 0;
        int val = matrix[r][c];
        if (r != 0 && val > matrix[r - 1][c]) res += findPath(r - 1, c);
        if (r != M - 1 && val > matrix[r + 1][c]) res += findPath(r + 1, c);
        if (c != 0 && val > matrix[r][c - 1]) res += findPath(r, c - 1);
        if (c != N - 1 && val > matrix[r][c + 1]) res += findPath(r, c + 1);
        return path[r][c] = res;
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