import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        int answer = 0;
        int num = 2;
        int sum = 0;
        Queue<Integer> sequence = new LinkedList<>();
        sequence.add(num);
        sum += num;
        while (!sequence.isEmpty()) {
            if (sum == N) {
                answer++;
                while (!isPrimeNumber(++num)) ;
                sequence.add(num);
                sum += num;
            } else if (sum > N) {
                sum -= sequence.poll();
            } else { // sum < num
                while (!isPrimeNumber(++num)) ;
                sequence.add(num);
                sum += num;
            }
        }
        bw.write(String.valueOf(answer));
    }

    public static boolean isPrimeNumber(int n) {
        if (n % 2 == 0) return false;
        else {
            for (int i = 2; i * i <= n; i++)
                if (n % i == 0) return false;
            return true;
        }
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