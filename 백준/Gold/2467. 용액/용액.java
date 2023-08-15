import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] solutions;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        solutions = new int[N];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < N; i++) solutions[i] = Integer.parseInt(values[i]);
    }

    public static void solve() throws IOException {
        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        int[] comb = {0, 0};
        while (left < right) {
            int diff = solutions[right] + solutions[left];
            if (Math.abs(diff) < min) {
                min = Math.abs(diff);
                comb[0] = solutions[left];
                comb[1] = solutions[right];
            }
            if (diff == 0) break;
            else if (diff < 0) left++;
            else right--;
        }
        bw.write(comb[0] + " " + comb[1]);
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