import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static boolean[] hasSelfNumber;

    public static void init() throws IOException {
        hasSelfNumber = new boolean[10001];
    }

    public static void solve() throws IOException {
        for (int i = 1; i <= 10000; i++) {
            int num = i;
            int sum = num;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum < 10001) hasSelfNumber[sum] = true;
        }
        for (int i = 1; i <= 10000; i++)
            if (!hasSelfNumber[i]) bw.write(i + "\n");
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