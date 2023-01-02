import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        divisors = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            int quot = M / i;
            for (int j = 1; j <= quot; j++) {
                divisors[i * j]++;
            }
        }
    }

    public static void solve() throws IOException {
        for (int i = N; i <= M; i++)
            if (divisors[i] == 2) bw.write(i + "\n");
    }


    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int M;
    static int[] divisors;

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