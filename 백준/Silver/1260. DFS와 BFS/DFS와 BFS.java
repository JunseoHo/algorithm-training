import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
    static LinkedList<Integer> res = new LinkedList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        // read graph
        String line = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line);
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int startIndex = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < N + 1; i++) graph.add(new LinkedList<>());

        // read edges
        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(tokenizer.nextToken());
            int destination = Integer.parseInt(tokenizer.nextToken());
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
        // sort edges
        for (LinkedList<Integer> v : graph) Collections.sort(v);

        // print result
        init();
        DFS(startIndex);
        for (int i : res) bw.write(i + " ");
        bw.write("\n");
        init();
        BFS(startIndex);
        for (int i : res) bw.write(i + " ");

        br.close();
        bw.close();
    }

    public static void init() {
        visit = new boolean[graph.size()];
        res = new LinkedList<>();
    }

    public static void DFS(int startIndex) {
        res.add(startIndex);
        visit[startIndex] = true;
        for (int v : graph.get(startIndex)) if (!visit[v]) DFS(v);
    }


    public static void BFS(int startIndex) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startIndex);
        visit[startIndex] = true;
        while (!que.isEmpty()) {
            int idx = que.poll();
            res.add(idx);
            for (int i : graph.get(idx))
                if (!visit[i]) {
                    que.add(i);
                    visit[i] = true;
                }
        }
    }

}