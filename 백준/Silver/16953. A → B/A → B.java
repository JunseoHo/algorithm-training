import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        A = Integer.parseInt(vars[0]);
        B = Integer.parseInt(vars[1]);
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(solve(B, A)));
    }

    public static int solve(int a, int b) {
        if (a == b) return 1;
        else if (a < b) return -1;
        else {
            int res = 0;
            if ((a - 1) % 10 == 0) {
                res = solve((a - 1) / 10, b);
                return res == -1 ? res : res + 1;
            } else if (a % 2 == 0) {
                res = solve(a / 2, b);
                return res == -1 ? res : res + 1;
            } else {
                return -1;
            }
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int A;
    static int B;

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