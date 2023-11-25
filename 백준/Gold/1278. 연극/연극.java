import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] stages;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        stages = new int[(int) Math.pow(2, N)];
        Arrays.fill(stages, -1);
    }

    public static void solve(int currentStage, int K) throws IOException {
        boolean isFinal = true;
        for (int i = 0; i < N; i++) {
            boolean isStaged = ((currentStage >> i) & 1) == 1;
            int mask = 1 << i;
            if (isStaged) {
                mask = ~mask;
                if (stages[currentStage & mask] == -1) {
                    bw.write((i + 1) + " \n");
                    stages[currentStage & mask] = K + 1;
                    solve(currentStage & mask, K + 1);
                    isFinal = false;
                }
            } else {
                if (stages[currentStage | mask] == -1) {
                    bw.write((i + 1) + " \n");
                    stages[currentStage | mask] = K + 1;
                    solve(currentStage | mask, K + 1);
                    isFinal = false;
                }
            }
        }
        if (isFinal) {
            int num = 0;
            while (currentStage != 1) {
                currentStage >>= 1;
                ++num;
            }
            bw.write((num + 1) + " \n");
        }
    }

    public static void solve() throws IOException {
        stages[0] = 0;
        bw.write((stages.length - 1) + "\n");
        solve(0, 0);
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