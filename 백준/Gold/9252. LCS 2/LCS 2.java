import java.io.*;

public class Main {

    static char[] s1;
    static char[] s2;
    static String[][] DP;

    public static void init() throws IOException {
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        DP = new String[s1.length][s2.length];
    }

    public static String solve(int i, int j) {
        if (i == s1.length || j == s2.length) return "";
        if (DP[i][j] != null) return DP[i][j];
        if (s1[i] == s2[j])
            DP[i][j] = s1[i] + solve(i + 1, j + 1);
        else {
            String tmp1 = solve(i + 1, j);
            String tmp2 = solve(i, j + 1);
            DP[i][j] = tmp1.length() > tmp2.length() ? tmp1 : tmp2;
        }
        return DP[i][j];
    }

    public static void solve() throws IOException {
        String lcs = solve(0, 0);
        bw.write(lcs.length() + "\n" + lcs);
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
