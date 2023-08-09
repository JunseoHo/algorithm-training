import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N, K, L;
    static int board[][];
    static List<int[]> snake;
    static Queue<int[]> turns;
    static int direction[];


    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++) board[r][c] = 0; // 0 = Empty, 1 = Apple, 2 = Snake
        for (int k = 0; k < K; k++) {
            String[] values = br.readLine().split(" ");
            board[Integer.parseInt(values[0]) - 1][Integer.parseInt(values[1]) - 1] = 1;
        }
        turns = new LinkedList<>();
        L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            String[] values = br.readLine().split(" ");
            turns.add(new int[]{Integer.parseInt(values[0]), values[1].equals("L") ? 0 : 1}); // 0 = Left, 1 = Right
        }
        board[0][0] = 2;
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        direction = new int[]{0, 1};
    }

    public static void solve() throws IOException {
        int time = 0;
        while (true) {
            ++time;
//            System.out.println("[" + time + " : " + direction[0] + ", " + direction[1] + "]");
//            for (int r = 0; r < N; r++) {
//                for (int c = 0; c < N; c++) System.out.print(board[r][c] + " ");
//                System.out.println();
//            }
            // move forward
            int head[] = snake.get(0);
            snake.add(0, new int[]{head[0] + direction[0], head[1] + direction[1]});
            head = snake.get(0);
            // check collision
            if (head[0] < 0 || head[0] > N - 1 || head[1] < 0 || head[1] > N - 1) break;
            if (board[head[0]][head[1]] == 2) break;
            // check apple
            if (board[head[0]][head[1]] != 1) {
                int tail[] = snake.get(snake.size() - 1);
                board[tail[0]][tail[1]] = 0;
                snake.remove(snake.size() - 1);
            } else {
                board[head[0]][head[1]] = 0;
            }
            board[head[0]][head[1]] = 2;
            if (!turns.isEmpty() && turns.peek()[0] == time) {
                int turn = turns.poll()[1];
                if (turn == 0) {
                    if (direction[0] == 0 && direction[1] == 1) direction = new int[]{-1, 0};
                    else if (direction[0] == -1 && direction[1] == 0) direction = new int[]{0, -1};
                    else if (direction[0] == 0 && direction[1] == -1) direction = new int[]{1, 0};
                    else if (direction[0] == 1 && direction[1] == 0) direction = new int[]{0, 1};
                } else {
                    if (direction[0] == 0 && direction[1] == 1) direction = new int[]{1, 0};
                    else if (direction[0] == -1 && direction[1] == 0) direction = new int[]{0, 1};
                    else if (direction[0] == 0 && direction[1] == -1) direction = new int[]{-1, 0};
                    else if (direction[0] == 1 && direction[1] == 0) direction = new int[]{0, -1};
                }
            }
        }
        bw.write(String.valueOf(time));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }
}
