import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static String S;
    static String[] croatiaAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void init() throws IOException {
        S = br.readLine();
    }

    public static void solve() throws IOException {
        int answer = 0;
        while (S.length() != 0) {
            boolean b = false;
            for (String croatiaAlphabet : croatiaAlphabets) {
                if (S.startsWith(croatiaAlphabet)) {
                    answer++;
                    S = S.substring(croatiaAlphabet.length());
                    b = true;
                    break;
                }
            }
            if (!b) {
                S = S.substring(1);
                answer++;
            }
        }
        bw.write(String.valueOf(answer));
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