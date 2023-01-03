import java.io.*;
import java.util.*;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                if (numbers[i - 1] + numbers[i] >= numbers[i])
                    numbers[i] = numbers[i - 1] + numbers[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            max = Math.max(max, numbers[i]);
        bw.write(max + "\n");
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[] numbers;

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