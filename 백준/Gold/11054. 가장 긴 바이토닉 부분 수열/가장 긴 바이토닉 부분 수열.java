import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] sequence;
    static int[] ascendingLength;
    static int[] descendingLength;
    static int max;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) sequence[i] = Integer.parseInt(tokenizer.nextToken());
        ascendingLength = new int[N];
        descendingLength = new int[N];
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            max = 0;
            for (int j = i; j > -1; j--) {
                if (sequence[j] < sequence[i])
                    max = Math.max(ascendingLength[j], max);
            }
            ascendingLength[i] = max + 1;
        }
        for (int i = N - 1; i > -1; i--) {
            max = 0;
            for (int j = i; j < N; j++) {
                if (sequence[j] < sequence[i])
                    max = Math.max(descendingLength[j], max);
            }
            descendingLength[i] = max + 1;
        }
        max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(ascendingLength[i] + descendingLength[i], max);
        bw.write(String.valueOf(max - 1));
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