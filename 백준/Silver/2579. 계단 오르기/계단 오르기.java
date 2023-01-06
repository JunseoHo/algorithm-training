import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        scores = new int[N];
        dpTable = new int[N];
        for (int i = 0; i < N; i++)
            scores[i] = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            if (i == 0) dpTable[i] = scores[i];
            else if (i == 1) dpTable[i] = scores[i] + scores[i - 1];
            else if (i == 2)
                dpTable[i] = Math.max(scores[i] + scores[i - 2], scores[i - 1] + scores[i]);
            else
                dpTable[i] = Math.max(dpTable[i - 2] + scores[i], dpTable[i - 3] + scores[i - 1] + scores[i]);
            
            // 반드시 마지막 계단을 밟아야 하므로 우항에 scores[i]가 반드시 포함되어야만 한다. 
            // 만약 그렇지 않은 우항이 있을 경우 마지막 계단을 밟지 않은 경우가 최댓값이 될 수 있어 틀린 답이 나올 수 있음
        }
        bw.write(String.valueOf(dpTable[N - 1]));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[] scores;
    static int[] dpTable;

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