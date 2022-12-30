import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V;
    static int E;
    static LinkedList<LinkedList<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        int answer = 0;
        while (!isCompleted()) {
            int idx = 0;
            for (int i = 1; i < V + 1; i++) {
                if (!visited[i]) {
                    idx = i;
                    break;
                }
            }
            Queue<Integer> que = new LinkedList();
            que.add(idx);
            visited[idx] = true;
            while (!que.isEmpty()) {
                int i = que.poll();
                for (int adj : adjList.get(i)) {
                    if (!visited[adj]) {
                        que.add(adj);
                        visited[adj] = true;
                    }
                }
            }
            answer++;
        }
        bw.write(answer + "\n");
        close();
    }

    public static boolean isCompleted() {
        for (int i = 1; i < V + 1; i++) if (!visited[i]) return false;
        return true;
    }

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        adjList = new LinkedList<>();
        for (int i = 0; i < V + 1; i++) adjList.add(new LinkedList<>());
        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            adjList.get(Integer.parseInt(input[0])).add(Integer.valueOf(input[1]));
            adjList.get(Integer.parseInt(input[1])).add(Integer.valueOf(input[0]));
        }
        visited = new boolean[V + 1];
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}