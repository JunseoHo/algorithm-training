import java.io.*;

public class Main {

    static int N;
    static int K;
    static int answer;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Integer.parseInt(values[0]);
        K = Integer.parseInt(values[1]);
        answer = Integer.MAX_VALUE;
    }

    public static void solve() throws IOException {

        if (N <= K)
            bw.write(String.valueOf(0));
        else {
            while (K > 0) {
                int p = 0;
                while (Math.pow(2, p) < N) ++p;
                if (answer >= (N - Math.pow(2, p)) * (-1))
                    answer = (int) ((N - Math.pow(2, p)) * (-1));
                N -= (int) (Math.pow(2, p - 1));
                --K;
            }
            bw.write(String.valueOf(answer));
        }
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
