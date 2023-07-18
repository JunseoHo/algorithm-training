import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static long N;
    static long P;
    static long Q;
    static Map<Long, Long> map;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        N = Long.parseLong(values[0]);
        P = Long.parseLong(values[1]);
        Q = Long.parseLong(values[2]);
        map = new HashMap<>();
        map.put(0L, 1L);
    }

    public static long find(long n) {
        if (map.get(n) != null) return map.get(n);
        long value = find(n / P) + find(n / Q);
        map.put(n, value);
        return value;
    }

    public static void solve() throws IOException {
        bw.write(find(N) + "\n");
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
