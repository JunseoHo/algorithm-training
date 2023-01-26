import javax.management.StringValueExp;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int M;
    static int r;
    static int c;
    static int d; // 0 : top, 1 : right, 2 : bottom, 3 : left
    static int[][] matrix; // -1 : cleaned, 0 : no cleaned, 1 : wall

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        M = Integer.parseInt(vars[1]);
        vars = br.readLine().split(" ");
        r = Integer.parseInt(vars[0]);
        c = Integer.parseInt(vars[1]);
        d = Integer.parseInt(vars[2]);
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void solve() throws IOException {
        int cleaning = 0;
        int searching = 0;
        while (true) {
            if (matrix[r][c] == 0) {
                matrix[r][c] = -1;
                cleaning++;
            }
            if (searching == 4) {
                int nextR = r;
                int nextC = c;
                if (d == 0) nextR++;
                if (d == 1) nextC--;
                if (d == 2) nextR--;
                if (d == 3) nextC++;
                if (matrix[nextR][nextC] == 1)
                    break;
                else {
                    r = nextR;
                    c = nextC;
                }
                searching = 0;
            }
            int nextR = r;
            int nextC = c;
            int nextD = d == 0 ? 3 : d - 1;
            if (d == 0) nextC--;
            if (d == 1) nextR--;
            if (d == 2) nextC++;
            if (d == 3) nextR++;
            if (matrix[nextR][nextC] == 0) {
                r = nextR;
                c = nextC;
                searching = 0;
            } else {
                searching++;
            }
            d = nextD;
        }
        bw.write(String.valueOf(cleaning));
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