import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int answer = 0;
        // read input
        int numOfVertices = Integer.parseInt(br.readLine());
        int numOfEdges = Integer.parseInt(br.readLine());
        // create graph
        for (int i = 0; i < numOfVertices + 1; i++) graph.add(new LinkedList<>());
        StringTokenizer tokenizer;
        for (int i = 0; i < numOfEdges; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        br.close();
        // BFS
        Queue<Integer> que = new LinkedList();
        boolean[] visited = new boolean[graph.size()];
        que.add(1);
        visited[1] = true;
        while (!que.isEmpty()) {
            int idx = que.poll();
            answer++;
            for (int adj : graph.get(idx))
                if (!visited[adj]) {
                    visited[adj] = true;
                    que.add(adj);
                }
        }
        // print answer
        System.out.print(answer - 1); // excluding computer indexed at 1
    }
}