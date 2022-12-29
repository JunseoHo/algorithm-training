import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (num < min) min = num;
            if (num > max) max = num;
        }
        bw.write(String.valueOf(min * max));
        br.close();
        bw.close();
    }

}