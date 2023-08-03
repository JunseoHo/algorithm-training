import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int T[];
    static int P[];
    static int dpTable[];

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        dpTable = new int[N + 2];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(tokenizer.nextToken());
            P[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.fill(dpTable, 0);
    }

    public static int extractMax(int index) {
        int max = 0;
        for (int i = 1; i <= index; i++)
            max = Math.max(max, dpTable[i]);
        return max;
    }

    public static void solve() throws IOException {
        for (int i = 1; i < N + 1; i++) {
            dpTable[i] = extractMax(i);
            if (i + T[i] < N + 2) {
                if (dpTable[i + T[i]] < dpTable[i] + P[i])
                    dpTable[i + T[i]] = dpTable[i] + P[i];
            }
        }
        bw.write(String.valueOf(extractMax(N + 1)));
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
