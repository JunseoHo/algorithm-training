import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dpTable = new int[N][N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(tokenizer.nextToken());
                if (j == 0) dpTable[i][j] = num;
                else dpTable[i][j] = dpTable[i][j - 1] + num;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dpTable[i][j] += dpTable[i - 1][j];
            }
        }
    }

    public static void solve() throws IOException {
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int y1 = Integer.parseInt(input[0]) - 1;
            int x1 = Integer.parseInt(input[1]) - 1;
            int y2 = Integer.parseInt(input[2]) - 1;
            int x2 = Integer.parseInt(input[3]) - 1;
            int answer = dpTable[y2][x2];
            if (y1 > 0) answer -= dpTable[y1 - 1][x2];
            if (x1 > 0) answer -= dpTable[y2][x1 - 1];
            if (x1 > 0 && y1 > 0) answer += dpTable[y1 - 1][x1 - 1];
            bw.write(answer + "\n");
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int M;
    static int[][] dpTable;

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