import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            List<Integer> seq = new ArrayList<>();
            int num = i;
            while (num != 0) {
                seq.add(num % 10);
                num /= 10;
            }
            if (isArithmeticSequence(seq)) answer++;
        }
        bw.write(String.valueOf(answer));
    }

    public static boolean isArithmeticSequence(List<Integer> seq) {
        if (seq.size() == 1) return true;
        int d = seq.get(1) - seq.get(0);
        for (int n = 1; n < seq.size(); n++) {
            if (seq.get(n) - seq.get(n - 1) != d) return false;
        }
        return true;
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