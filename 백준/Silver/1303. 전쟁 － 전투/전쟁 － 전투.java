import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int M;
    static String[][] matrix;
    static int W;
    static int B;


    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[1]);
        M = Integer.parseInt(values[0]);
        matrix = new String[N][M];
        for (int i = 0; i < N; i++) {
            values = br.readLine().split("");
            for (int j = 0; j < M; j++)
                matrix[i][j] = values[j];
        }
        W = 0;
        B = 0;
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!matrix[i][j].equals("V")) {
                    String team = matrix[i][j];
                    int count = 0;
                    Queue<int[]> que = new LinkedList<>();
                    que.add(new int[]{i, j});
                    matrix[i][j] = "V";
                    while (!que.isEmpty()) {
                        int[] position = que.poll();
                        ++count;
                        int r = position[0];
                        int c = position[1];
                        if (c > 0 && matrix[r][c - 1].equals(team)) {
                            matrix[r][c - 1] = "V";
                            que.add(new int[]{r, c - 1});
                        }
                        if (c < M - 1 && matrix[r][c + 1].equals(team)) {
                            matrix[r][c + 1] = "V";
                            que.add(new int[]{r, c + 1});
                        }
                        if (r > 0 && matrix[r - 1][c].equals(team)) {
                            matrix[r - 1][c] = "V";
                            que.add(new int[]{r - 1, c});
                        }
                        if (r < N - 1 && matrix[r + 1][c].equals(team)) {
                            matrix[r + 1][c] = "V";
                            que.add(new int[]{r + 1, c});
                        }
                    }
                    if (team.equals("W")) W += Math.pow(count, 2);
                    if (team.equals("B")) B += Math.pow(count, 2);
                }
            }
        }
        System.out.println(W + " " + B);
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