import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
        numbers = new int[N];
        vars = br.readLine().split(" ");
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(vars[i]);
        Arrays.sort(numbers);
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            print(String.valueOf(numbers[i]), 2, M);
        }
    }

    public static void print(String seq, int current, int m) throws IOException {
        if (current > m) bw.write(seq + "\n");
        else if (current == m) {
            String[] split = seq.split(" ");
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < split.length; j++) list.add(Integer.valueOf(split[j]));
            for (int i = 0; i < N; i++) {
                if (!list.contains(numbers[i])) {
                    bw.write(seq + " " + numbers[i] + "\n");
                }
            }
        } else {
            String[] split = seq.split(" ");
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < split.length; j++) list.add(Integer.valueOf(split[j]));
            for (int i = 0; i < N; i++) {
                if (!list.contains(numbers[i])) {
                    print(seq + " " + numbers[i], current + 1, m);
                }
            }
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int M;
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