import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
      ArrayList<String> vertices = new ArrayList<>();
        vertices.add(begin);
        for (String word : words) vertices.add(word);
        if (!vertices.contains(target)) return 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) edges.add(new ArrayList<>());
        for (int i = 0; i < vertices.size() - 1; i++)
            for (int j = i + 1; j < vertices.size(); j++) {
                LinkedList<Character> s1 = new LinkedList<>();
                LinkedList<Character> s2 = new LinkedList<>();
                for (Character c : vertices.get(i).toCharArray()) s1.add(c);
                for (Character c : vertices.get(j).toCharArray()) s2.add(c);
                for (Character c1 : s1) if (s2.contains(c1)) s2.remove(c1);
                if (s2.size() == 1) {
                    edges.get(i).add(j);
                    edges.get(j).add(i);
                }
            }
        int[] distance = new int[vertices.size()];
        for (int i = 0; i < distance.length; i++) distance[i] = -1;
        distance[0] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        while (!que.isEmpty()) {
            int index = que.poll();
            if (vertices.get(index).equals(target)) return distance[index];
            for (int adjacent : edges.get(index))
                if (distance[adjacent] == -1) {
                    que.add(adjacent);
                    distance[adjacent] = distance[index] + 1;
                }
        }
        return 0;
    }
}