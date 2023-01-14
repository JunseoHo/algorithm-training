import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
    }

    public static void solve() throws IOException {
        for (int i = 1; i <= N; i++) {
            print(i, String.valueOf(i), 2, M);
        }
    }

    public static void print(int pre, String seq, int current, int m) throws IOException {
        if (current > m) bw.write(seq + "\n");
        else if (current == m) {
            for (int i = pre; i <= N; i++) {
                bw.write(seq + " " + i + "\n");
            }
        } else {
            for (int i = pre; i <= N; i++) {
                print(i, seq + " " + i, current + 1, m);
            }
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int M;

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