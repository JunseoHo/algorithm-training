

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        // read graph
        String line = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        matrix = new int[N][M];
        // read matrix
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        findPath(0, 0);
        // print result
        System.out.println(matrix[N - 1][M - 1]);
        br.close();
        bw.close();
    }

    public static void findPath(int i, int j) {
        // top
        int row = i - 1;
        int col = j;
        findPath(i, j, row, col);
        // right
        row = i;
        col = j + 1;
        findPath(i, j, row, col);
        // bottom
        row = i + 1;
        col = j;
        findPath(i, j, row, col);
        // left
        row = i;
        col = j - 1;
        findPath(i, j, row, col);
    }

    public static void findPath(int i, int j, int row, int col) {
        if (row > -1 && row < matrix.length && col > -1 && col < matrix[0].length && matrix[row][col] > 0) {
            if (matrix[row][col] == 1 && !(row == 0 && col == 0)) {
                matrix[row][col] = matrix[i][j] + 1;
                findPath(row, col);
            } else {
                if (matrix[row][col] > matrix[i][j] + 1) {
                    matrix[row][col] = matrix[i][j] + 1;
                    findPath(row, col);
                }
            }
        }


    }
}
