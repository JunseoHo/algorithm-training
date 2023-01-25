import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static String[] str;

    public static void init() throws IOException {
        str = br.readLine().split("");
    }

    public static void solve() throws IOException {
        int stack = 0;
        for (String s : str) {
            if (s.equals("(")) stack++;
            else if (s.equals(")")) {
                if (stack == 0) {
                    bw.write("NO\n");
                    return;
                } else stack--;
            }
        }
        bw.write(stack == 0 ? "YES\n" : "NO\n");
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
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init();
            solve();
        }
        close();
    }

}