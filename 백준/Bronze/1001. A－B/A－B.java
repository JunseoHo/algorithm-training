import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        System.out.println(Integer.parseInt(vars[0]) - Integer.parseInt(vars[1]));
    }

    public static void solve() throws IOException {

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