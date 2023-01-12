import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            vars = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(vars[j]);
            }
        }
        breakableWalls = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean isWall = matrix[i][j] == 1;
                boolean hasPathFromTop = i != 0 && matrix[i - 1][j] == 0;
                boolean hasPathFromLeft = j != 0 && matrix[i][j - 1] == 0;
                boolean hasPathFromRight = j != M - 1 && matrix[i][j + 1] == 0;
                boolean hasPathFromBottom = i != N - 1 && matrix[i + 1][j] == 0;
                if (isWall && (hasPathFromTop || hasPathFromLeft) && (hasPathFromRight || hasPathFromBottom)) {
                    breakableWalls.add(new int[]{i, j});
                }
            }
        }
        distFromSource = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distFromSource[i][j] = -1;
            }
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        distFromSource[0][0] = 1;
        while (!que.isEmpty()) {
            int[] loc = que.poll();
            int row = loc[0];
            int col = loc[1];
            int val = distFromSource[row][col];
            if (col != M - 1 && matrix[row][col + 1] == 0 && distFromSource[row][col + 1] == -1) {
                que.add(new int[]{row, col + 1});
                distFromSource[row][col + 1] = val + 1;
            }
            if (row != N - 1 && matrix[row + 1][col] == 0 && distFromSource[row + 1][col] == -1) {
                que.add(new int[]{row + 1, col});
                distFromSource[row + 1][col] = val + 1;
            }
            if (col != 0 && matrix[row][col - 1] == 0 && distFromSource[row][col - 1] == -1) {
                que.add(new int[]{row, col - 1});
                distFromSource[row][col - 1] = val + 1;
            }
            if (row != 0 && matrix[row - 1][col] == 0 && distFromSource[row - 1][col] == -1) {
                que.add(new int[]{row - 1, col});
                distFromSource[row - 1][col] = val + 1;
            }
        }
        distFromDestin = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distFromDestin[i][j] = -1;
            }
        }
        que = new LinkedList<>();
        que.add(new int[]{N - 1, M - 1});
        distFromDestin[N - 1][M - 1] = 1;
        while (!que.isEmpty()) {
            int[] loc = que.poll();
            int row = loc[0];
            int col = loc[1];
            int val = distFromDestin[row][col];
            if (col != M - 1 && matrix[row][col + 1] == 0 && distFromDestin[row][col + 1] == -1) {
                que.add(new int[]{row, col + 1});
                distFromDestin[row][col + 1] = val + 1;
            }
            if (row != N - 1 && matrix[row + 1][col] == 0 && distFromDestin[row + 1][col] == -1) {
                que.add(new int[]{row + 1, col});
                distFromDestin[row + 1][col] = val + 1;
            }
            if (col != 0 && matrix[row][col - 1] == 0 && distFromDestin[row][col - 1] == -1) {
                que.add(new int[]{row, col - 1});
                distFromDestin[row][col - 1] = val + 1;
            }
            if (row != 0 && matrix[row - 1][col] == 0 && distFromDestin[row - 1][col] == -1) {
                que.add(new int[]{row - 1, col});
                distFromDestin[row - 1][col] = val + 1;
            }
        }
    }

    public static void solve() throws IOException {
        int min = distFromSource[N - 1][M - 1] != -1 ? distFromSource[N - 1][M - 1] : Integer.MAX_VALUE;
        for (int[] loc : breakableWalls) {
            int row = loc[0];
            int col = loc[1];
            int top = (row != 0 && distFromSource[row - 1][col] != -1) ? distFromSource[row - 1][col] : Integer.MAX_VALUE;
            int left = (col != 0 && distFromSource[row][col - 1] != -1) ? distFromSource[row][col - 1] : Integer.MAX_VALUE;
            int right = (col != M - 1 && distFromDestin[row][col + 1] != -1) ? distFromDestin[row][col + 1] : Integer.MAX_VALUE;
            int bottom = (row != N - 1 && distFromDestin[row + 1][col] != -1) ? distFromDestin[row + 1][col] : Integer.MAX_VALUE;
            int dist = Math.min(top, left) + Math.min(right, bottom) + 1;
            if (dist > 0 && dist < min) min = dist;
        }
        bw.write(String.valueOf(min == Integer.MAX_VALUE ? -1 : min));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int M;
    static int[][] matrix;
    static List<int[]> breakableWalls;
    static int[][] distFromSource;
    static int[][] distFromDestin;

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