import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        sequence = new int[N];
        dpTable = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void solve() throws IOException {
        int max = 1;
        for (int i = 0; i < N; i++) {
            if (i == 0) dpTable[i] = 1;
            else {
                int val = 0;
                for (int j = i; j > -1; j--) {
                    if (sequence[j] > sequence[i] && dpTable[j] > val) {
                        val = dpTable[j];
                    }
                }
                dpTable[i] = val + 1;
                max = Math.max(dpTable[i], max);
            }
        }
        bw.write(String.valueOf(max));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[] sequence;
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