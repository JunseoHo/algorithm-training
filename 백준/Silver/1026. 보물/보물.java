import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static void solve() throws IOException {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        for (int i = 0; i < N; i++)
            answer += A[i] * B[N - 1 - i];
        bw.write(String.valueOf(answer));
        /*
        0 1 1 1 6
         */
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int[] A;
    static int[] B;

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