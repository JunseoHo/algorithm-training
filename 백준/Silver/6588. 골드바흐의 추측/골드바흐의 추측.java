import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;

    public static void init() throws IOException {
    }

    public static void solve() throws IOException {
        int num;
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            int a = 3;
            while (a != num) {
                if (isPrimeNumber(a) && isPrimeNumber(num - a)) {
                    bw.write(num + " = " + a + " + " + (num - a) + "\n");
                    break;
                }
                a++;
            }
            if (a == num) bw.write("Goldbach's conjecture is wrong.\n");
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n % 2 == 0) return false;
        else {
            for (int i = 2; i * i <= n; i++)
                if (n % i == 0) return false;
            return true;
        }
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