import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;
    static int[] selection;
    static int[] state;
    static int count;

    /*
    state...
    -1 = not searched
    0 = is searching
    1 = searching is over
     */

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        selection = new int[N + 1];
        state = new int[N + 1];
        Arrays.fill(state, -1);
        count = 0;
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int val = Integer.parseInt(tokenizer.nextToken());
            selection[i] = val;
            if (i == val) {
                state[i] = 1;
                count++;
            }
        }
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++)
            if (state[i] == -1) DFS(i);
        bw.write((N + 1 - count) + "\n");
    }

    public static int DFS(int idx) {
        if (state[idx] == 0) { // idx에서 시작되고 끝나는 순환이 존재한다
            state[idx] = 1;
            count++;
            return idx;
        } else if (state[idx] == 1) {
            return 0;
        } else {
            state[idx] = 0;
            int cycle = DFS(selection[idx]);
            if (cycle == 0 || cycle == idx) {
                state[idx] = 1;
                return 0;
            } else {
                state[idx] = 1;
                count++;
                return cycle;
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
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init();
            solve();
        }
        close();
    }

}