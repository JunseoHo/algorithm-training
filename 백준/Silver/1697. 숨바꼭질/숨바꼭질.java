import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        visited = new int[100001];
        Arrays.fill(visited, -1);
    }

    public static void solve() throws IOException {
        bw.write(findPath() + "\n");
    }

    public static int findPath() {
        if (N == K) return 0;
        else if (N > K) return N - K;
        else {
            Queue<Integer> que = new LinkedList<>();
            que.add(N);
            visited[N] = 0;
            while (!que.isEmpty()) {
                int idx = que.poll();
                if (idx == K) return visited[K];
                if (idx != 0 && visited[idx - 1] == -1) {
                    visited[idx - 1] = visited[idx] + 1;
                    que.add(idx - 1);
                }
                if (idx != 100000 && visited[idx + 1] == -1) {
                    visited[idx + 1] = visited[idx] + 1;
                    que.add(idx + 1);
                }
                if (idx * 2 < 100001 && visited[idx * 2] == -1) {
                    visited[idx * 2] = visited[idx] + 1;
                    que.add(idx * 2);
                }
            }
        }
        return -1;
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int K;
    static int[] visited;

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