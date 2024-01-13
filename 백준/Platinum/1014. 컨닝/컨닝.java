import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int C;
    static int N, M;
    static boolean[][] isUsable;
    static boolean[][] seats;
    static int[][] dpTable;

    public static void init() throws IOException {
        C = Integer.parseInt(br.readLine());
    }

    public static boolean checkSeat(int row, int col) {
        if (row >= N || row < 0) return false;
        if (col >= M || col < 0) return false;
        return seats[row][col];
    }

    public static int fromSeatToInt(int row) {
        int i = 0;
        for (int index = 0; index < M; index++)
            if (seats[row][index]) i += Math.pow(2, index);
        return i;
    }

    public static int countRow(int row) {
        int count = 0;
        for (int j = 0; j < M; j++) if (seats[row][j]) ++count;
        return count;
    }

    public static int simulate(int row, int col, int answer) {
        if (row == N) return answer;
        if (col == M) {
            if (dpTable[row][fromSeatToInt(row)] != -1) return answer + dpTable[row][fromSeatToInt(row)];
            dpTable[row][fromSeatToInt(row)] = (simulate(row + 1, 0, answer) - answer);
            return (answer + dpTable[row][fromSeatToInt(row)]);
        }
        if (!isUsable[row][col]) return simulate(row, col + 1, answer);
        if (!checkSeat(row - 1, col - 1)
                && !checkSeat(row, col - 1)
                && !checkSeat(row - 1, col + 1)
                && !checkSeat(row, col + 1)) {
            seats[row][col] = true;
            int sit = simulate(row, col + 1, answer + 1);
            seats[row][col] = false;
            int noSit = simulate(row, col + 1, answer);
            return Math.max(sit, noSit);
        } else return simulate(row, col + 1, answer);
    }


    public static void solve() throws IOException {
        for (int caseNumber = 0; caseNumber < C; caseNumber++) {
            String[] tokens = br.readLine().split(" ");
            N = Integer.parseInt(tokens[0]);
            M = Integer.parseInt(tokens[1]);
            isUsable = new boolean[N][M];
            for (int row = 0; row < N; row++) {
                char[] arr = br.readLine().toCharArray();
                for (int col = 0; col < M; col++) isUsable[row][col] = arr[col] == '.';
            }
            seats = new boolean[N][M];
            dpTable = new int[10][1024];
            for (int i = 0; i < 10; i++) for (int j = 0; j < 1024; j++) dpTable[i][j] = -1;
            bw.write(simulate(0, 0, 0) + "\n");
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