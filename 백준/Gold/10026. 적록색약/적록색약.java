import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        matrix = new String[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++)
                matrix[i][j] = row[j];
        }
    }

    public static void solve() throws IOException {
        int district = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    district++;
                    distinguish(i, j, matrix[i][j]);
                }
        bw.write(district + " ");
        district = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (matrix[i][j].equals("G")) matrix[i][j] = "R";
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j]) {
                    district++;
                    distinguish(i, j, matrix[i][j]);
                }
        bw.write(district + " ");
    }

    public static void distinguish(int row, int col, String color) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row, col});
        visited[row][col] = true;
        while (!que.isEmpty()) {
            int[] loc = que.poll();
            if (loc[1] != 0 && matrix[loc[0]][loc[1] - 1].equals(color) && !visited[loc[0]][loc[1] - 1]) {
                visited[loc[0]][loc[1] - 1] = true;
                que.add(new int[]{loc[0], loc[1] - 1});
            }
            if (loc[0] != 0 && matrix[loc[0] - 1][loc[1]].equals(color) && !visited[loc[0] - 1][loc[1]]) {
                visited[loc[0] - 1][loc[1]] = true;
                que.add(new int[]{loc[0] - 1, loc[1]});
            }
            if (loc[1] != N - 1 && matrix[loc[0]][loc[1] + 1].equals(color) && !visited[loc[0]][loc[1] + 1]) {
                visited[loc[0]][loc[1] + 1] = true;
                que.add(new int[]{loc[0], loc[1] + 1});
            }
            if (loc[0] != N - 1 && matrix[loc[0] + 1][loc[1]].equals(color) && !visited[loc[0] + 1][loc[1]]) {
                visited[loc[0] + 1][loc[1]] = true;
                que.add(new int[]{loc[0] + 1, loc[1]});
            }
        }
    }


    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static String[][] matrix;
    static boolean[][] visited;

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