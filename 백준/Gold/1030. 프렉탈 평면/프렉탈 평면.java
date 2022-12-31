import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        s = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        R1 = Integer.parseInt(input[3]);
        R2 = Integer.parseInt(input[4]);
        C1 = Integer.parseInt(input[5]);
        C2 = Integer.parseInt(input[6]);
        maxSize = (int) Math.pow(N, s);
    }

    public static void solve() throws IOException {
        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) bw.write(String.valueOf(findColor(0, 0, i, j, 1)));
            bw.write("\n");
        }
    }

    public static int findColor(int nowR, int nowC, int r, int c, int time) {
        if (time > s) return 0;
        int ratio = (int) (maxSize / Math.pow(N, time));
        int margin = (N - K) / 2;
        // check center
        if (r >= nowR + margin * ratio && r < nowR + (margin + K) * ratio && c >= nowC + margin * ratio && c < nowC + (margin + K) * ratio) {
            return 1;
        }
        int nextR = 0;
        int nextC = 0;
        for (int i = 0; i < N; i++) {
            boolean isSelected = false;
            for (int j = 0; j < N; j++) {
                nextR = nowR + i * ratio;
                nextC = nowC + j * ratio;
                if (r >= nextR && r < nextR + ratio && c >= nextC && c < nextC + ratio) {
                    isSelected = true;
                    break;
                }
            }
            if (isSelected) break;
        }
        return findColor(nextR, nextC, r, c, time + 1);
    }


    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int s;
    static int N;
    static int K;
    static int R1;
    static int R2;
    static int C1;
    static int C2;
    static int maxSize;

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