import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        arr = br.readLine().toCharArray();
        for (int i = 1; i < N; i++) {
            char[] cmd = br.readLine().toCharArray();
            for (int j = 0; j < cmd.length; j++) {
                if (arr[j] != cmd[j]) arr[j] = '?';
            }
        }
        bw.write(String.valueOf(arr));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static char[] arr;

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