import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int[] numbers;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] vars = br.readLine().split(" ");
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(vars[i]);
    }

    public static void solve() throws IOException {
        int answer = 0;
        for (int num : numbers) {
            if (num == 1) continue;
            boolean isPrimeNumber = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) isPrimeNumber = false;
            }
            if (isPrimeNumber) answer++;
        }
        bw.write(String.valueOf(answer));
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