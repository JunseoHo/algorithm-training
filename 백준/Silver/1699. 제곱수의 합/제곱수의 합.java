import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        dpTable = new int[N + 1];
        Arrays.fill(dpTable, -1);
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(findCombination(N)));
    }

    public static int findCombination(int n) {
        if (n == 0) return dpTable[n] = 0;
        if (n == 1) return dpTable[n] = 1;
        if (dpTable[n] != -1) return dpTable[n];
        int sqrt = (int) Math.floor(Math.sqrt(n));
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= sqrt; i++) {
            int count = 0;
            while (Math.pow(i, 2) * count <= n) count++;
            min = Math.min(min, (count - 1) + findCombination((int) (n - Math.pow(i, 2) * (count - 1))));
        }
        dpTable[n] = min;
        return dpTable[n];
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
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