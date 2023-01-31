import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] vars = br.readLine().split(" ");
            switch (vars[0]) {
                case "push_front":
                    list.addFirst(Integer.valueOf(vars[1]));
                    break;
                case "push_back":
                    list.addLast(Integer.valueOf(vars[1]));
                    break;
                case "pop_front":
                    if (list.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(list.removeFirst() + "\n");
                    break;
                case "pop_back":
                    if (list.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(list.removeLast() + "\n");
                    break;
                case "size":
                    bw.write(list.size() + "\n");
                    break;
                case "empty":
                    bw.write((list.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    if (list.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(list.getFirst() + "\n");
                    break;
                case "back":
                    if (list.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(list.getLast() + "\n");
                    break;
            }
        }
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