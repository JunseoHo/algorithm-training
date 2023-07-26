import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int A[];
    static int B[];

    public static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        A = new int[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine());
        M = Integer.parseInt(tokenizer.nextToken());
        B = new int[M];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) B[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static int findGCD(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    public static void solve() throws IOException {
        long answer = 1;
        boolean overflow = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                long gcd = findGCD(A[i], B[j]);
                answer *= gcd;
                A[i] /= gcd;
                B[j] /= gcd;
                if (answer >= 1000000000) {
                    answer %= 1000000000;
                    overflow = true;
                }
            }
        }
        if (overflow) System.out.printf("%09d", answer);
        else bw.write(String.valueOf(answer));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }
}
