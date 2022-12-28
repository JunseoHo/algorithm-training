import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int n, int[][] computers) {
      int answer = 0;
        boolean[] visited = new boolean[n];
        int index = 0;
        do {
            Queue<Integer> que = new LinkedList<>();
            que.add(index);
            visited[index] = true;
            while (!que.isEmpty()) {
                int computer = que.poll();
                for (int i = 0; i < n; i++)
                    if (computers[computer][i] == 1 && !visited[i]) {
                        que.add(i);
                        visited[i] = true;
                    }
            }
            answer++;
            index = -1;
            for (int i = 0; i < visited.length; i++) if (!visited[i]) index = i;
        } while (index != -1);
        return answer;
    }
}