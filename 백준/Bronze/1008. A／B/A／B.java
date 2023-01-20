import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int V;
    static int E;
    static List<List<int[]>> graph;
    static boolean[] connected;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        bw.write(String.valueOf(Double.parseDouble(vars[0]) / Double.parseDouble(vars[1])));
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