import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static int[] line;
    static List<Integer> people;
    static Stack<Integer> stack;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        line = new int[N * 5];
        people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] vars = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                String[] ticket = vars[j].split("-");
                char[] alp = ticket[0].toCharArray();
                String num = ticket[1];
                int id = (alp[0] * 1000) + Integer.parseInt(num);
                people.add(id);
                line[i * 5 + j] = id;
            }
        }
        Collections.sort(people);
        stack = new Stack<>();
    }

    public static void solve() throws IOException {
        int idx = 0;
        for (int order : people) {
            while (!equalWithPeek(order) && (idx < N * 5 && line[idx] != order)) {
                stack.push(line[idx]);
                idx++;
            }
            if (idx < N * 5 && line[idx] == order) {
                idx++;
            } else if (equalWithPeek(order)) {
                stack.pop();
            }
        }
        bw.write(stack.isEmpty() ? "GOOD" : "BAD");
    }

    public static boolean equalWithPeek(int num) {
        if (stack.isEmpty()) return false;
        return stack.peek() == num;
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