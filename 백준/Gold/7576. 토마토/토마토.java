import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int N;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        init();
        List<int[]> recentRipe = new LinkedList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) if (matrix[i][j] == 1) recentRipe.add(new int[]{i, j});
        ripen(recentRipe, 1);
        int day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (matrix[i][j] == 0) {
                    day = -1;
                    break;
                } else if (matrix[i][j] > day) {
                    day = matrix[i][j];
                }
            if (day == -1) break;
        }
        if (day > -1) day--;
        bw.write(day + "\n");
        close();
    }

    public static void ripen(List<int[]> oldRipe, int day) {
        if (oldRipe.size() == 0) return;
        List<int[]> recentRipe = new LinkedList<>();
        for (int[] ripe : oldRipe) {
            int row = ripe[0];
            int col = ripe[1];
            if (row - 1 > -1 && matrix[row - 1][col] == 0) {
                matrix[row - 1][col] = day + 1;
                recentRipe.add(new int[]{row - 1, col});
            }
            if (col + 1 < M && matrix[row][col + 1] == 0) {
                matrix[row][col + 1] = day + 1;
                recentRipe.add(new int[]{row, col + 1});
            }
            if (row + 1 < N && matrix[row + 1][col] == 0) {
                matrix[row + 1][col] = day + 1;
                recentRipe.add(new int[]{row + 1, col});
            }
            if (col - 1 > -1 && matrix[row][col - 1] == 0) {
                matrix[row][col - 1] = day + 1;
                recentRipe.add(new int[]{row, col - 1});
            }
        }
        ripen(recentRipe, day + 1);
    }

    public static void init() throws IOException {
        String[] size = br.readLine().split(" ");
        M = Integer.parseInt(size[0]);
        N = Integer.parseInt(size[1]);
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) matrix[i][j] = Integer.parseInt(row[j]);
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}