import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        dpTable = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i < s1.length + 1; i++)
            for (int j = 0; j < s2.length + 1; j++) {
                dpTable[i][j] = 0;
            }
    }

    public static void solve() throws IOException {
        for (int i = 1; i < s1.length + 1; i++)
            for (int j = 1; j < s2.length + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
                else dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
            }
        bw.write(String.valueOf(dpTable[s1.length][s2.length]));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static char[] s1;
    static char[] s2;
    static int[][] dpTable;

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