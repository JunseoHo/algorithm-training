import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N * 2 - 1];
    }

    public static void solve() throws IOException {
        draw(0, 0, N);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++)
                bw.write(map[i][j] ? "*" : " ");
            bw.write("\n");
        }
    }

    public static void draw(int row, int col, int height) {
        if (height == 3) {
            map[row][col + 2] = true;
            map[row + 1][col + 1] = true;
            map[row + 1][col + 3] = true;
            for (int i = 0; i < 5; i++) map[row + 2][col + i] = true;
        } else {
            draw(row, col + (height - 1) - (height / 2 - 1), height / 2);
            draw(row + height / 2, col, height / 2);
            draw(row + height / 2, col + height, height / 2);
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static boolean[][] map;
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