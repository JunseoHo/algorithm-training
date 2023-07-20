import java.io.*;

public class Main {

    static int n;
    static int recursionCount;
    static int dpCount;
    static int dpTable[];

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        recursionCount = 0;
        dpCount = 0;
        dpTable = new int[41];
        dpTable[1] = 1;
        dpTable[2] = 1;
    }

    public static int recursion(int n) {
        if (n == 1 || n == 2) {
            ++recursionCount;
            return 1;
        } else return (recursion(n - 1) + recursion(n - 2));
    }

    public static int dp(int n) {
        dpTable[1] = 1;
        dpTable[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
            ++dpCount;
        }
        return dpTable[n];
    }

    public static void solve() throws IOException {
        recursion(n);
        dp(n);
        bw.write(recursionCount + " " + dpCount);
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
