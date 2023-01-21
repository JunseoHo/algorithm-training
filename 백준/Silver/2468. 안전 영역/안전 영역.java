import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int highest;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        highest = 0;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                highest = Math.max(highest, matrix[i][j]);
            }
        }
        visited = new boolean[N][N];
    }

    public static void solve() throws IOException {
        int answer = 0;
        for (int i = 0; i <= highest; i++) {
            answer = Math.max(answer, solve(i));
        }
        bw.write(String.valueOf(answer));
    }

    public static int solve(int sink) throws IOException {
        visited = new boolean[N][N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (matrix[i][j] <= sink) {
                        visited[i][j] = true;
                    } else { // matrix[i][j] > sink
                        answer++;
                        Queue<int[]> que = new LinkedList<>();
                        que.add(new int[]{i, j});
                        visited[i][j] = true;
                        while (!que.isEmpty()) {
                            int[] loc = que.poll();
                            int row = loc[0];
                            int col = loc[1];
                            if (row != 0 && !visited[row - 1][col]) {
                                visited[row - 1][col] = true;
                                if (matrix[row - 1][col] > sink) que.add(new int[]{row - 1, col});
                            }
                            if (col != N - 1 && !visited[row][col + 1]) {
                                visited[row][col + 1] = true;
                                if (matrix[row][col + 1] > sink) que.add(new int[]{row, col + 1});
                            }
                            if (row != N - 1 && !visited[row + 1][col]) {
                                visited[row + 1][col] = true;
                                if (matrix[row + 1][col] > sink) que.add(new int[]{row + 1, col});
                            }
                            if (col != 0 && !visited[row][col - 1]) {
                                visited[row][col - 1] = true;
                                if (matrix[row][col - 1] > sink) que.add(new int[]{row, col - 1});
                            }
                        }
                    }
                }
            }
        }
        return answer;
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