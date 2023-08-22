import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int R, C;
    static int[][] matrix;
    static boolean[][] visited;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        R = Integer.parseInt(values[0]);
        C = Integer.parseInt(values[1]);
        matrix = new int[Integer.parseInt(values[0])][Integer.parseInt(values[1])];
        int K = Integer.parseInt(values[2]);
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                matrix[i][j] = 0;
        for (int i = 0; i < K; i++) {
            values = br.readLine().split(" ");
            int x1 = Integer.parseInt(values[0]);
            int y1 = Integer.parseInt(values[1]);
            int x2 = Integer.parseInt(values[2]);
            int y2 = Integer.parseInt(values[3]);
            for (int row = R - 1 - y1; row >= R - y2; row--) {
                for (int col = x1; col < x2; col++) {
                    matrix[row][col] = 1;
                }
            }
        }
        visited = new boolean[R][C];
    }

    public static void solve() throws IOException {
        List<Integer> answer = new ArrayList<>();
        for (int row = 0; row < R; row++)
            for (int col = 0; col < C; col++) {
                if (matrix[row][col] == 0 && !visited[row][col]) {
                    int size = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{row, col});
                    visited[row][col] = true;
                    while (!queue.isEmpty()) {
                        int[] co = queue.poll();
                        int i = co[0];
                        int j = co[1];
                        ++size;
                        if (i > 0 && matrix[i - 1][j] == 0 && !visited[i - 1][j]) {
                            visited[i - 1][j] = true;
                            queue.add(new int[]{i - 1, j});
                        }
                        if (i < R - 1 && matrix[i + 1][j] == 0 && !visited[i + 1][j]) {
                            visited[i + 1][j] = true;
                            queue.add(new int[]{i + 1, j});
                        }
                        if (j > 0 && matrix[i][j - 1] == 0 && !visited[i][j - 1]) {
                            visited[i][j - 1] = true;
                            queue.add(new int[]{i, j - 1});
                        }
                        if (j < C - 1 && matrix[i][j + 1] == 0 && !visited[i][j + 1]) {
                            visited[i][j + 1] = true;
                            queue.add(new int[]{i, j + 1});
                        }
                    }
                    answer.add(size);
                }
            }
        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for (int i : answer) {
            bw.write(i + " ");
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