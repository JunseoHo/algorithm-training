import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++)
                triangle[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void solve() throws IOException {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) triangle[i][j] += triangle[i - 1][j];
                else if (j == i) triangle[i][j] += triangle[i - 1][j - 1];
                else
                    triangle[i][j] += triangle[i - 1][j - 1] > triangle[i - 1][j] ? triangle[i - 1][j - 1] : triangle[i - 1][j];
            }
        }
        int max = -1;
        for (int i : triangle[N - 1]) {
            max = i > max ? i : max;
        }
        bw.write(String.valueOf(max));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[][] triangle;

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