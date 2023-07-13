import java.io.*;
import java.util.*;

public class Main {


    static class Vertex {
        int id;
        int time;
        int cumulativeTime;

        public Vertex(int id, int time) {
            this.id = id;
            this.time = time;
            this.cumulativeTime = time;
        }

        public void setCumulativeTime(int cumulativeTime) {
            this.cumulativeTime = cumulativeTime;
        }

    }

    static int n;
    static List<List<Vertex>> graph;
    static int[] time;

    public static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        time = new int[n];
        Arrays.fill(time, 0);
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(tokenizer.nextToken()) - 1;
            int time = Integer.parseInt(tokenizer.nextToken());
            graph.get(level).add(new Vertex(i, time));
        }
    }

    public static void solve() throws IOException {
        int index = 0;
        for (; index < graph.size(); index++) {
            for (Vertex u : graph.get(index)) time[index] = Math.max(time[index], u.cumulativeTime);
            if (index + 1 == graph.size() || graph.get(index + 1).size() == 0) break;
            for (Vertex u : graph.get(index)) {
                for (Vertex v : graph.get(index + 1)) {
                    int maxTime = u.cumulativeTime + v.time + (int) Math.pow(u.id - v.id, 2);
                    if (maxTime > v.cumulativeTime) v.setCumulativeTime(maxTime);
                }
            }
        }
        bw.write(String.valueOf(time[index]));
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
