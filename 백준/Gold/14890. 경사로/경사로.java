import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static int L;
    static int[][] matrix;

    public static void init() throws IOException {
        String[] vars = br.readLine().split(" ");
        N = Integer.parseInt(vars[0]);
        L = Integer.parseInt(vars[1]);
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void solve() throws IOException {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int[] row = new int[N];
            int[] col = new int[N];
            for (int j = 0; j < N; j++) row[j] = matrix[i][j];
            for (int j = 0; j < N; j++) col[j] = matrix[j][i];
            if (canBeRoad(row)) answer++;
            if (canBeRoad(col)) answer++;
        }
        bw.write(String.valueOf(answer));
    }

    public static boolean canBeRoad(int[] road) {
        boolean[] isSlope = new boolean[road.length];
        for (int i = 1; i < N; i++) {
            if (Math.abs(road[i] - road[i - 1]) > 1) return false; //높이가 두 칸 이상인 부분이 있을 경우
            else if (road[i] - road[i - 1] == 1) { // 높이가 한 칸 높아질 경우
                if (i < L) return false; // 지나온 길의 거리가 L 보다 작아 경사로를 놓을 수 없음
                else {
                    for (int j = 1; j < L + 1; j++) {
                        if ((road[i - j] == road[i] - 1) && !isSlope[i - j])
                            isSlope[i - j] = true;
                        else return false;  // 경사로를 놓을 자리의 높이가 적절하지 않거나 이미 경사로인 경우
                    }
                }
            } else if (road[i - 1] - road[i] == 1) { // 높이가 한 칸 낮아질 경우
                if (N - i < L) return false; // 앞으로 경사로를 놓을 수 있는 거리가 L 보다 작아 경사로를 놓을 수 없음
                else {
                    for (int j = 0; j < L; j++) {
                        if ((road[i + j] == road[i - 1] - 1) && !isSlope[i + j])
                            isSlope[i + j] = true;
                        else return false; // 경사로를 놓을 자리의 높이가 적절하지 않거나 이미 경사로인 경우
                    }
                }
            } // 그 외의 경우는 높이가 똑같은 경우이므로 그냥 지나갈 수 있다
        }
        return true;
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