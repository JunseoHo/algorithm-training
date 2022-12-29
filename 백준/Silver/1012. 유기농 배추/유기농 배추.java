import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int T = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        for (int i = 0; i < T; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
            int K = Integer.parseInt(tokenizer.nextToken());
            int[][] matrix = new int[N][M];
            for (int j = 0; j < N; j++)
                for (int k = 0; k < M; k++)
                    matrix[j][k] = 0;
            boolean[][] visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                tokenizer = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(tokenizer.nextToken());
                int Y = Integer.parseInt(tokenizer.nextToken());
                matrix[Y][X] = 1;
            }
            for (int k = 0; k < N; k++) {
                for (int l = 0; l < M; l++) {
                    if (!visited[k][l]) {
                        if (matrix[k][l] == 1) {
                            Queue<int[]> que = new LinkedList<>();
                            que.add(new int[]{k, l});
                            while (!que.isEmpty()) {
                                int[] coordinate = que.poll();
                                int coRow = coordinate[0];
                                int coCol = coordinate[1];
                                int row = coRow - 1;
                                int col = coCol;
                                if (row > -1 && matrix[row][col] == 1 && !visited[row][col]) {
                                    que.add(new int[]{row, col});
                                    visited[row][col] = true;
                                }
                                row = coRow;
                                col = coCol + 1;
                                if (col < M && matrix[row][col] == 1 && !visited[row][col]) {
                                    que.add(new int[]{row, col});
                                    visited[row][col] = true;
                                }
                                row = coRow + 1;
                                col = coCol;
                                if (row < N && matrix[row][col] == 1 && !visited[row][col]) {
                                    que.add(new int[]{row, col});
                                    visited[row][col] = true;
                                }
                                row = coRow;
                                col = coCol - 1;
                                if (col > -1 && matrix[row][col] == 1 && !visited[row][col]) {
                                    que.add(new int[]{row, col});
                                    visited[row][col] = true;
                                }
                            }
                            answer++;
                        } else visited[k][l] = true;
                    }
                }
            }
            bw.write(String.valueOf(answer) + "\n");
            answer = 0;
        }

        br.close();
        bw.close();
    }

}