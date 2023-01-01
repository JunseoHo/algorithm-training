import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        tiles = new int[N + 1];
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N + 1; i++) {
            if (i == 0) tiles[i] = 0;
            else if (i == 1) tiles[i] = 1;
            else if (i == 2) tiles[i] = 2;
            else tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 10007;
        }
        bw.write(tiles[N] + "\n");
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[] tiles;

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