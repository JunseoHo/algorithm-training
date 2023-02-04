import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] sequence;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        for (int i = 0; i < N; i++) sequence[i] = Integer.parseInt(br.readLine());

    }

    public static void solve() throws IOException {
        int num = 1;
        int order = 0;
        Stack<Integer> stack = new Stack<>();
        List<String> list = new LinkedList<>();
        while (order < N) {
            int element = sequence[order];
            if (num == element) {
                list.add("+");
                list.add("-");
                num++;
                order++;
            } else if (num < element) {
                while (num != element) {
                    stack.push(num++);
                    list.add("+");
                }
                list.add("+");
                list.add("-");
                num++;
                order++;
            } else {
                int poppedNum = stack.pop();
                if (element == poppedNum) {
                    list.add("-");
                    order++;
                } else {
                    bw.write("NO");
                    return;
                }
            }
        }
        for (String s : list) bw.write(s + "\n");
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