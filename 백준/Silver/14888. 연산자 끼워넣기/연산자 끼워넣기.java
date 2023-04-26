import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] A;
    static int[] operator;
    static int max;
    static int min;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(values[i]);
        operator = new int[4];
        values = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(values[i]);
        max = -1_000_000_000;
        min = 1_000_000_000;
    }

    public static void solve() throws IOException {
        operate(A, operator, 1, A[0]);
        bw.write(String.valueOf(max) + "\n");
        bw.write(String.valueOf(min));
    }

    private static void operate(int[] A, int[] operator, int depth, int value) {
        if (depth == N - 1) {
            if (operator[0] == 1)
                value += A[N - 1];
            if (operator[1] == 1)
                value -= A[N - 1];
            if (operator[2] == 1)
                value *= A[N - 1];
            if (operator[3] == 1)
                value /= A[N - 1];
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        if (!(operator[0] == 0 && operator[2] == 0 && value < max)) {
            if (operator[0] > 0) {
                operator[0] -= 1;
                operate(A, operator, depth + 1, value + A[depth]);
                operator[0] += 1;
            }
            if (operator[2] > 0) {
                operator[2] -= 1;
                operate(A, operator, depth + 1, value * A[depth]);
                operator[2] += 1;
            }
        }
        if (!(operator[1] == 0 && operator[3] == 0 && value > min)) {
            if (operator[1] > 0) {
                operator[1] -= 1;
                operate(A, operator, depth + 1, value - A[depth]);
                operator[1] += 1;
            }
            if (operator[3] > 0) {
                operator[3] -= 1;
                operate(A, operator, depth + 1, value / A[depth]);
                operator[3] += 1;
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