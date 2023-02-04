import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] sequence;
    static Stack[] stacks;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        stacks = new Stack[4];
        for (int i = 0; i < 4; i++) stacks[i] = new Stack();
        String[] vars = br.readLine().split(" ");
        for (int i = 0; i < N; i++) sequence[i] = Integer.parseInt(vars[i]);
    }

    public static void solve() throws IOException {
        for (int i : sequence) {
            boolean isPushed = false;
            for (Stack stack : stacks) {
                if (stack.isEmpty() || (int)stack.peek() < i){
                    stack.push(i);
                    isPushed = true;
                    break;
                }
            }
            if (!isPushed) {
                bw.write("NO");
                return;
            }
        }
        bw.write("YES");
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