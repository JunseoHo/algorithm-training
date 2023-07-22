import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char maze[][];
    static int dist[][][];
    static int[] startPoint;
    static List<int[]> endPoints;

    public static void init() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        maze = new char[N][M];
        dist = new int[N][M][64];
        startPoint = new int[2];
        endPoints = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = row[j];
                for (int k = 0; k < 64; k++) dist[i][j][k] = -1;
                if (maze[i][j] == '0') {
                    startPoint = new int[]{i, j};
                    dist[i][j][0] = 0;
                }
                if (maze[i][j] == '1') endPoints.add(new int[]{i, j});
            }
        }
    }

    public static boolean isAvailable(int r, int c, int k) {
        if (maze[r][c] == '#') return false;
        if (maze[r][c] >= 'A' && maze[r][c] <= 'F') {
            int validation = 1 << (maze[r][c] - 65);
            if ((validation & k) != 0) return true;
            return false;
        }
        return true;
    }

    public static boolean isVisited(int r, int c, int k) {
        return dist[r][c][k] != -1;
    }

    public static int takeKey(int r, int c, int k) {
        if (maze[r][c] >= 'a' && maze[r][c] <= 'f')
            return k | 1 << (maze[r][c] - 97);
        return k;
    }

    public static void solve() throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPoint[0], startPoint[1], 0});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int k = info[2];
            int nextK;
            if (maze[r][c] == '1') continue;
            // check top
            if (r != 0 && isAvailable(r - 1, c, k)) {
                nextK = takeKey(r - 1, c, k);
                if (!isVisited(r - 1, c, nextK)) {
                    dist[r - 1][c][nextK] = dist[r][c][k] + 1;
                    queue.add(new int[]{r - 1, c, nextK});
                }
            }
            // check right
            if (c != M - 1 && isAvailable(r, c + 1, k)) {
                nextK = takeKey(r, c + 1, k);
                if (!isVisited(r, c + 1, nextK)) {
                    dist[r][c + 1][nextK] = dist[r][c][k] + 1;
                    queue.add(new int[]{r, c + 1, nextK});
                }
            }
            // check bottom
            if (r != N - 1 && isAvailable(r + 1, c, k)) {
                nextK = takeKey(r + 1, c, k);
                if (!isVisited(r + 1, c, nextK)) {
                    dist[r + 1][c][nextK] = dist[r][c][k] + 1;
                    queue.add(new int[]{r + 1, c, nextK});
                }
            }
            // check left
            if (c != 0 && isAvailable(r, c - 1, k)) {
                nextK = takeKey(r, c - 1, k);
                if (!isVisited(r, c - 1, nextK)) {
                    dist[r][c - 1][nextK] = dist[r][c][k] + 1;
                    queue.add(new int[]{r, c - 1, nextK});
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int[] endPoint : endPoints) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 64; i++) {
                if (dist[endPoint[0]][endPoint[1]][i] != -1)
                    min = Math.min(min, dist[endPoint[0]][endPoint[1]][i]);
            }
            answer = Math.min(answer, min);
        }
        if (answer == Integer.MAX_VALUE) answer = -1;
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
