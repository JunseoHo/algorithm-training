import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] dpTable;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        dpTable = new int[N + 1];
    }

    public static void solve() throws IOException {
        dpTable[0] = 1;
        dpTable[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            dpTable[i] = (dpTable[i - 1] + dpTable[i - 2]) % 15746;
            // 0 :
            // 1 : 1
            // 2 : 00 11
            // 3 : 001 100 111
            // 4 : 1111 0011 1001 1100 0000
            // 5 : 11111 00111 10011 11001 11100 00001 00100 10000
        }
        dpTable[0] = 0;
        bw.write(String.valueOf(dpTable[N]));
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