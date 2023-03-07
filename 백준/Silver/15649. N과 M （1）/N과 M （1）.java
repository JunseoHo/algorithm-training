import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int M;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        M = Integer.parseInt(values[1]);
    }

    public static void print(int depth, List<Integer> selected) throws IOException {
        if (depth == M) {
            for (Integer i : selected)
                bw.write(i + " ");
            bw.write("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (!selected.contains(i)) {
                    selected.add(i);
                    print(depth + 1, selected);
                    selected.remove(selected.indexOf(i));
                }
            }
        }
    }

    public static void solve() throws IOException {
        print(0, new LinkedList<>());
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