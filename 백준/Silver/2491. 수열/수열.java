import java.io.*;

public class Main {

    static int N;
    static int[] list;
    static int[][] dpTable;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] values = br.readLine().split(" ");
        list = new int[N];
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(values[i]);
        dpTable = new int[N][2];
    }

    public static void solve() throws IOException {
        if (N == 1) {
            bw.write("1");
            return;
        }
        int asc = 1;
        int desc = 1;
        dpTable[0][0] = 1;
        dpTable[0][1] = 1;
        for (int i = 1; i < N; i++) {
            if (list[i] >= list[i - 1]) dpTable[i][0] = dpTable[i - 1][0] + 1;
            else dpTable[i][0] = 1;
            if (list[i] <= list[i - 1]) dpTable[i][1] = dpTable[i - 1][1] + 1;
            else dpTable[i][1] = 1;
            asc = Math.max(asc, dpTable[i][0]);
            desc = Math.max(desc, dpTable[i][1]);
        }
        bw.write(String.valueOf(Math.max(asc, desc)));
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
