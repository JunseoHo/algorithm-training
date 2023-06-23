import java.io.*;

public class Main {

    static int N;
    static int S;
    static int[] seq;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        S = Integer.parseInt(values[1]);
        seq = new int[N];
        values = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(values[i]);
    }

    public static void solve() throws IOException {
        int i = 0;
        int j = 0;
        int answer = Integer.MAX_VALUE;
        int sum = seq[j];
        while (i != N - 1 || j != N - 1) {
            if (sum < S) {
                if (j < N - 1) {
                    sum = sum + seq[j + 1];
                    ++j;
                } else if (i < N - 1) {
                    sum = sum - seq[i];
                    ++i;
                }
            } else {
                if ((j - i + 1) < answer && sum >= S) {
                    answer = j - i + 1;
                }
                sum = sum - seq[i];
                ++i;
                if ((j - i + 1) < answer && sum >= S) {
                    answer = j - i + 1;
                }
                if (i == j && j < N - 1) {
                    sum = sum + seq[j + 1];
                    ++j;
                }
            }
        }
        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? 0 : answer));
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