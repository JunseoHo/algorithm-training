import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static int M;
    static int[][] matrix;
    static int[][] exposure;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        M = Integer.parseInt(values[1]);
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            values = br.readLine().split(" ");
            for (int j = 0; j < M; j++)
                matrix[i][j] = Integer.parseInt(values[j]);
        }
    }

    public static void initExposure() {
        exposure = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                exposure[i][j] = 0;
    }

    public static boolean isEmpty() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (matrix[i][j] == 1)
                    return false;
        return true;
    }

    public static int[] findStart() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if ((i == 0 || i == N - 1 || j == 0 || j == M - 1) && matrix[i][j] == 0)
                    return new int[]{i, j};
        return null;
    }

    public static void solve() throws IOException {
        int answer = 0;
        while (!isEmpty()) {
            int[] start = findStart();
            initExposure();
            Queue<int[]> que = new LinkedList<>();
            que.add(start);
            exposure[start[0]][start[1]] = -1;
            while (!que.isEmpty()) {
                int[] loc = que.poll();
                int row = loc[0];
                int col = loc[1];
                if (row != 0) {
                    if (matrix[row - 1][col] == 0 && exposure[row - 1][col] != -1) {
                        que.add(new int[]{row - 1, col});
                        exposure[row - 1][col] = -1;
                    }
                    if (matrix[row - 1][col] == 1)
                        exposure[row - 1][col]++;
                }
                if (row != N - 1) {
                    if (matrix[row + 1][col] == 0 && exposure[row + 1][col] != -1) {
                        que.add(new int[]{row + 1, col});
                        exposure[row + 1][col] = -1;
                    }
                    if (matrix[row + 1][col] == 1)
                        exposure[row + 1][col]++;
                }
                if (col != 0) {
                    if (matrix[row][col - 1] == 0 && exposure[row][col - 1] != -1) {
                        que.add(new int[]{row, col - 1});
                        exposure[row][col - 1] = -1;
                    }
                    if (matrix[row][col - 1] == 1)
                        exposure[row][col - 1]++;
                }
                if (col != M - 1) {
                    if (matrix[row][col + 1] == 0 && exposure[row][col + 1] != -1) {
                        que.add(new int[]{row, col + 1});
                        exposure[row][col + 1] = -1;
                    }
                    if (matrix[row][col + 1] == 1)
                        exposure[row][col + 1]++;
                }
            }
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if (matrix[i][j] == 1 && exposure[i][j] >= 2) {
                        matrix[i][j] = 0;
                    }
            answer++;
        }
        bw.write(String.valueOf(answer));
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