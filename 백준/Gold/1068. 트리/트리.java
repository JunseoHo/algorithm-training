import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] tree;
    static int[] children;
    static int D;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new int[N];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            tree[i] = Integer.parseInt(values[i]);
        D = Integer.parseInt(br.readLine());
        children = new int[N];
        Arrays.fill(children, 0);
    }

    public static void delete(int d) {
        for (int i = 0; i < N; i++) {
            if (tree[i] == d) {
                delete(i);
                tree[i] = -2;
            }
        }
        tree[d] = -2;
    }

    public static void solve() throws IOException {
        int leaf = 0;
        delete(D);
        for (int i = 0; i < N; i++) {
            if (tree[i] >= 0)
                children[tree[i]]++;
        }
        for (int i = 0; i < N; i++) {
            if (tree[i] != -2 && children[i] == 0)
                leaf++;
        }
        bw.write(String.valueOf(leaf));
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