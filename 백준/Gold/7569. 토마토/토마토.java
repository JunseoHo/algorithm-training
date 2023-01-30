import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int M;
    static int N;
    static int H;
    static int[][][] tomatoes;
    static boolean[][][] visited;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
        H = Integer.parseInt(vars[2]);
        tomatoes = new int[H][M][N];
        visited = new boolean[H][M][N];
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int n = 0; n < N; n++) {
                    int val = Integer.parseInt(tokenizer.nextToken());
                    tomatoes[h][m][n] = val;
                }
            }
        }
    }

    public static void solve() throws IOException {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (tomatoes[h][m][n] == 1 && !visited[h][m][n]) {
                        que.add(new int[]{h, m, n});
                        visited[h][m][n] = true;
                    }
                }
            }
        }
        while (!que.isEmpty()) {
            Queue<int[]> temp = new LinkedList<>();
            while (!que.isEmpty()) {
                int[] loc = que.poll();
                int h = loc[0];
                int m = loc[1];
                int n = loc[2];
                if (m != 0 && tomatoes[h][m - 1][n] == 0 && !visited[h][m - 1][n]) {
                    temp.add(new int[]{h, m - 1, n});
                    tomatoes[h][m - 1][n] = 1;
                    visited[h][m - 1][n] = true;
                }
                if (n != N - 1 && tomatoes[h][m][n + 1] == 0 && !visited[h][m][n + 1]) {
                    temp.add(new int[]{h, m, n + 1});
                    tomatoes[h][m][n + 1] = 1;
                    visited[h][m][n + 1] = true;
                }
                if (m != M - 1 && tomatoes[h][m + 1][n] == 0 && !visited[h][m + 1][n]) {
                    temp.add(new int[]{h, m + 1, n});
                    tomatoes[h][m + 1][n] = 1;
                    visited[h][m + 1][n] = true;
                }
                if (n != 0 && tomatoes[h][m][n - 1] == 0 && !visited[h][m][n - 1]) {
                    temp.add(new int[]{h, m, n - 1});
                    tomatoes[h][m][n - 1] = 1;
                    visited[h][m][n - 1] = true;
                }
                if (h != 0 && tomatoes[h - 1][m][n] == 0 && !visited[h - 1][m][n]) {
                    temp.add(new int[]{h - 1, m, n});
                    tomatoes[h - 1][m][n] = 1;
                    visited[h - 1][m][n] = true;
                }
                if (h != H - 1 && tomatoes[h + 1][m][n] == 0 && !visited[h + 1][m][n]) {
                    temp.add(new int[]{h + 1, m, n});
                    tomatoes[h + 1][m][n] = 1;
                    visited[h + 1][m][n] = true;
                }
            }
            que = temp;
            answer++;
        }
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (tomatoes[h][m][n] == 0) {
                        bw.write(String.valueOf(-1));
                        return;
                    }
                }
            }
        }
        bw.write(String.valueOf(answer - 1));
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