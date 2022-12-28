import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
class Solution {
    public int solution(int n, int[][] edge) {
      int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;
        LinkedList<LinkedList<Integer>> adjacentList = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) adjacentList.add(new LinkedList<>());
        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            adjacentList.get(u).add(v);
            adjacentList.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjacentList.get(u))
                if (distances[v] == -1) {
                    distances[v] = distances[u] + 1;
                    queue.add(v);
                }
        }
        int max = 0;
        int answer = 0;
        for (int i : distances) max = Math.max(max, i);
        for (int i : distances) if (i == max) answer++;
        return answer;
    }
}