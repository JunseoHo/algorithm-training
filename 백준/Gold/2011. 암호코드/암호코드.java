import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int[] arr;
    static int[] dpTable;

    public static void init() throws IOException {
        String[] values = br.readLine().split("");
        arr = new int[values.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(values[i]);
        dpTable = new int[arr.length];
        Arrays.fill(dpTable, 0);
    }

    public static void dp(int x) {
        if (x >= dpTable.length)
            return;
        if (x == 0) {
            if (arr[x] != 0)
                ++dpTable[x];
        } else {
            if (arr[x] != 0)
                dpTable[x] += dpTable[x - 1];
            if (arr[x - 1] != 0 && (arr[x - 1] * 10 + arr[x]) < 27) {
                if (x != 1)
                    dpTable[x] += dpTable[x - 2];
                else
                    dpTable[x] += 1;
            }
        }
        dpTable[x] %= 1000000;
        dp(x + 1);
    }

    public static void solve() throws IOException {
        dp(0);
        bw.write(String.valueOf(dpTable[dpTable.length - 1]));
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