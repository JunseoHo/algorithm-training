import java.io.*;

public class Main {

    static String L;
    static String R;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        L = values[0];
        R = values[1];
    }

    public static void solve() throws IOException {
        int answer = 0;
        boolean same = true;
        while (L.length() < R.length()) L = '0' + L;
        for (int i = 0; i < R.length(); i++) {
            int l = L.charAt(i) - '0';
            int r = R.charAt(i) - '0';
            if (l != r) same = false;
            if (r == 0) r = 10;
            if (same && r == 8 && l == 8) ++answer;
        }
        bw.write(String.valueOf(answer));
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