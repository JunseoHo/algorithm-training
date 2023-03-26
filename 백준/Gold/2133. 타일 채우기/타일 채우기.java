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
        for (int i = 0; i < N + 1; i++) {
            if (i == 0)
                dpTable[i] = 1;
            else if (i % 2 == 1)
                dpTable[i] = 0;
            else {
                dpTable[i] += dpTable[i - 2] * 3;
                int j = 4;
                while (i - j > -1) {
                    if (i - j == 0)
                        dpTable[i] += 2;
                    else
                        dpTable[i] += dpTable[i - j] * 2;
                    j += 2;
                }
            }
        }
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