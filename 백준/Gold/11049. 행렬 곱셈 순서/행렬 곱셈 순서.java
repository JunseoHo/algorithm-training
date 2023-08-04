import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<int[]> matrices;
    static int[][] dpTable;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        matrices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] values = br.readLine().split(" ");
            matrices.add(new int[]{Integer.parseInt(values[0]), Integer.parseInt(values[1])});
        }
        dpTable = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dpTable[i][j] = -1;
    }

    public static int chaining(int i, int j) {
        if (dpTable[i][j] != -1) return dpTable[i][j];
        if (i >= j) return 0;
        if (i + 1 == j) {
            dpTable[i][j] = matrices.get(i)[0] * matrices.get(i)[1] * matrices.get(j)[1];
            return dpTable[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, chaining(i, k) + chaining(k + 1, j) +
                    + matrices.get(i)[0] * matrices.get(k)[1] * matrices.get(j)[1]);
        }
        dpTable[i][j] = min;
        return min;
    }

    public static void solve() throws IOException {
        bw.write(String.valueOf(chaining(0, N - 1)));
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
