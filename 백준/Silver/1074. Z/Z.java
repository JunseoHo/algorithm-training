import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
        visited = false;
    }

    public static void solve() throws IOException {
        bw.write(viZit(0, 0, (int) Math.pow(2, N)) + "\n");
    }

    public static int viZit(int row, int col, int len) {
        if (len == 1) {
            if (row == r && col == c) visited = true;
            return visited ? 0 : 1;
        } else {
            if (r >= row && r < row + (len / 2) && c >= col && c < col + (len / 2))
                return viZit(row, col, len / 2);
            if (r >= row && r < row + (len / 2) && c >= col + (len / 2) && c < col + len)
                return (int) (Math.pow(len / 2, 2) + viZit(row, col + (len / 2), len / 2));
            if (r >= row + (len / 2) && r < row + len && c >= col && c < col + (len / 2))
                return (int) (Math.pow(len / 2, 2) * 2 + viZit(row + (len / 2), col, len / 2));
            return (int) (Math.pow(len / 2, 2) * 3 + viZit(row + (len / 2), col + (len / 2), len / 2));
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int r;
    static int c;
    static boolean visited;

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