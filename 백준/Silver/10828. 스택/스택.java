import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        stack = new int[10000];
        top = -1;
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    stack[++top] = Integer.parseInt(command[1]);
                    break;
                case "pop":
                    if (top == -1) bw.write("-1" + "\n");
                    else bw.write(stack[top--] + "\n");
                    break;
                case "size":
                    bw.write((top + 1) + "\n");
                    break;
                case "empty":
                    bw.write((top == -1 ? 1 : 0) + "\n");
                    break;
                case "top":
                    if (top == -1) bw.write("-1"+ "\n");
                    else bw.write((stack[top]) + "\n");
                    break;
            }
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[] stack;
    static int top;

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