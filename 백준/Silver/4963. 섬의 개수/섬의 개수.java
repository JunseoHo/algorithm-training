import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
    }

    public static void solve() throws IOException {
        ArrayList<Integer> answers = new ArrayList<>();
        while (true) {
            String sizeStr = br.readLine();
            if (sizeStr.equals("0 0")) break;
            String[] size = sizeStr.split(" ");
            int W = Integer.parseInt(size[0]);
            int H = Integer.parseInt(size[1]);
            int[][] field = new int[H][W];
            boolean[][] visited = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++)
                    field[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
            int answer = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        answer++;
                        Queue<int[]> que = new LinkedList<>();
                        que.add(new int[]{i, j});
                        visited[i][j] = true;
                        while (!que.isEmpty()) {
                            int[] loc = que.poll();
                            int row = loc[0];
                            int col = loc[1];
                            if (row != 0 && field[row - 1][col] == 1 && !visited[row - 1][col]) {
                                que.add(new int[]{row - 1, col});
                                visited[row - 1][col] = true;
                            }
                            if (row != 0 && col != W - 1 && field[row - 1][col + 1] == 1 && !visited[row - 1][col + 1]) {
                                que.add(new int[]{row - 1, col + 1});
                                visited[row - 1][col + 1] = true;
                            }
                            if (col != W - 1 && field[row][col + 1] == 1 && !visited[row][col + 1]) {
                                que.add(new int[]{row, col + 1});
                                visited[row][col + 1] = true;
                            }
                            if (row != H - 1 && col != W - 1 && field[row + 1][col + 1] == 1 && !visited[row + 1][col + 1]) {
                                que.add(new int[]{row + 1, col + 1});
                                visited[row + 1][col + 1] = true;
                            }
                            if (row != H - 1 && field[row + 1][col] == 1 && !visited[row + 1][col]) {
                                que.add(new int[]{row + 1, col});
                                visited[row + 1][col] = true;
                            }
                            if (row != H - 1 && col != 0 && field[row + 1][col - 1] == 1 && !visited[row + 1][col - 1]) {
                                que.add(new int[]{row + 1, col - 1});
                                visited[row + 1][col - 1] = true;
                            }
                            if (col != 0 && field[row][col - 1] == 1 && !visited[row][col - 1]) {
                                que.add(new int[]{row, col - 1});
                                visited[row][col - 1] = true;
                            }
                            if (row != 0 && col != 0 && field[row - 1][col - 1] == 1 && !visited[row - 1][col - 1]) {
                                que.add(new int[]{row - 1, col - 1});
                                visited[row - 1][col - 1] = true;
                            }
                        }
                    }
                }
            }
            answers.add(answer);
        }
        for (int i : answers) System.out.println(i);
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;

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