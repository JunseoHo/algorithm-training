import java.io.*;

public class Main {

    static int T;

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(values[i]);
            int sum = 0;
            for (int i = 1; i < N; i++) sum += arr[i];
            if (sum % 2 == arr[0] % 2) {
                bw.write("YES\n");
            } else
                bw.write("NO\n");
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
