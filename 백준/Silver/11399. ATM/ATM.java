import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] times;

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(times);
        for (int i = 0; i < N - 1; i++) times[i + 1] += times[i];
        int answer = 0;
        for (int i = 0; i < N; i++) answer += times[i];
        bw.write(answer + "\n");
        close();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        times = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) times[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}