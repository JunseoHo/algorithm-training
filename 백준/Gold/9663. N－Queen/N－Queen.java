import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] field;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        field = new int[N];
    }

    public static boolean promising(int pos, int depth) {
        for (int cmp = 0; cmp < depth; cmp++) {
            if (field[cmp] == pos)
                return false;
            if (field[cmp] + (depth - cmp) == pos)
                return false;
            if (field[cmp] - (depth - cmp) == pos)
                return false;
        }
        return true;
    }

    public static int setQueen(int n, int depth) {
        int result = 0;
        if (depth == n)
            return 1;
        else {
            for (int pos = 0; pos < n; pos++) {
                if (promising(pos, depth)) {
                    field[depth] = pos;
                    result += setQueen(n, depth + 1);
                }
            }
        }
        return result;
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(setQueen(N, 0)));
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