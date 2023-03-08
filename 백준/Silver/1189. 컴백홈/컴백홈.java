import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int R;
    static int C;
    static int K;
    static String[][] map;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        R = Integer.parseInt(values[0]);
        C = Integer.parseInt(values[1]);
        K = Integer.parseInt(values[2]);
        map = new String[R][C];

        for (int r = 0; r < R; r++) {
            String[] row = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                map[r][c] = row[c];
            }
        }
    }

    public static void solve() throws IOException {
        boolean[][] visited = new boolean[R][C];
        visited[R - 1][0] = true;
        bw.write(String.valueOf(dfs(R - 1, 0, 1, visited)));
    }

    public static int dfs(int r, int c, int distance, boolean[][] visited) {
        if (r == 0 && c == C - 1 && distance == K)
            return 1;
        if (r == 0 && c == C - 1)
            return 0;
        visited[r][c] = true;
        int answer = 0;
        if (c > 0 && !visited[r][c - 1] && !map[r][c - 1].equals("T"))
            answer += dfs(r, c - 1, distance + 1, visited);
        if (c < C - 1 && !visited[r][c + 1] && !map[r][c + 1].equals("T"))
            answer += dfs(r, c + 1, distance + 1, visited);
        if (r > 0 && !visited[r - 1][c] && !map[r - 1][c].equals("T"))
            answer += dfs(r - 1, c, distance + 1, visited);
        if (r < R - 1 && !visited[r + 1][c] && !map[r + 1][c].equals("T"))
            answer += dfs(r + 1, c, distance + 1, visited);
        visited[r][c] = false;
        return answer;
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
