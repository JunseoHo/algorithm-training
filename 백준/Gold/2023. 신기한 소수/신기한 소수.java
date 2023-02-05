import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        for (int i = 1; i < 10; i++) {
            solve(1, i);
        }
    }

    public static void solve(int digit, int num) throws IOException {
        if (digit == N) {
            if (isPrimeNumber(num)) bw.write(num + "\n");
        } else {
            if (isPrimeNumber(num)) {
                for (int i = 1; i < 10; i++) {
                    solve(digit + 1, num * 10 + i);
                }
            }
        }
    }

    public static boolean isPrimeNumber(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0) return false;
        return true;
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