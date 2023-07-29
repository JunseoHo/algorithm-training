import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] graph;
    static int[][] dist;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) graph[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
        dist = new int[N][(int) Math.pow(2, N)];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < Math.pow(2, N); j++) {
                dist[i][j] = -1;
            }
        }
    }

    public static int checkVisited(int status, int city) {
        int mask = 1 << city;
        status &= mask;
        status >>= city;
        return status;
    }

    public static int findDist(int start, int status) {
        if (dist[start][status] != -1) return dist[start][status];
        if (status == (Math.pow(2, N) - 1)) {
            return (graph[start][0]);
        }
        int min = 999999999;
        for (int end = 0; end < N; end++) {
            int visited = checkVisited(status, end);
            if (visited == 0 && graph[start][end] != 0) {
                visited = status;
                visited |= 1 << end;
                int subDist = findDist(end, visited);
                if (subDist != 0) min = Math.min(min, graph[start][end] + subDist);
            }
        }
        if (min != Integer.MAX_VALUE) dist[start][status] = min;
        return min;
    }

    public static void solve() throws IOException {
        int start = 0;
        int status = 1;
        bw.write(String.valueOf(findDist(start, status)));
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
