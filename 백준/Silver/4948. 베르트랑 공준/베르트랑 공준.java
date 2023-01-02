import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String input;
        N = new ArrayList<>();
        while (!(input = br.readLine()).equals("0"))
            N.add(Integer.parseInt(input));
        divisors = new int[123457 * 2];
        for (int i = 1; i <= 123456 * 2 - 1; i++) {
            int quot = (123456 * 2 - 1) / i;
            for (int j = 1; j <= quot; j++) {
                divisors[i * j]++;
            }
        }
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N.size(); i++) {
            int num = N.get(i);
            int count = 0;
            for (int j = num + 1; j <= num * 2; j++) {
                if (divisors[j] == 2) count++;
            }
            bw.write(count + "\n");
        }
    }


    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static List<Integer> N;
    static int[] divisors;

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