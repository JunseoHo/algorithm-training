import java.util.*;
class Solution {
  public static String[] solution(String[][] tickets) {
        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<ArrayList<String>> edges = new ArrayList<>();
        for (String[] ticket : tickets) {
            String departure = ticket[0];
            String arrival = ticket[1];
            if (!vertices.contains(departure)) {
                vertices.add(departure);
                edges.add(new ArrayList<>());
            }
            if (!vertices.contains(arrival)) {
                vertices.add(arrival);
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < vertices.size(); i++) {
                if (vertices.get(i).equals(departure)) {
                    edges.get(i).add(arrival);
                    Collections.sort(edges.get(i));
                    break;
                }
            }
        }
        LinkedList<String> res = findPath(vertices, edges, "ICN", tickets.length);
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static LinkedList<String> findPath(ArrayList<String> vertices, ArrayList<ArrayList<String>> edges, String departure, int length) {
        if (length == 0) {
            LinkedList<String> path = new LinkedList<>();
            path.add(departure);
            return path;
        }
        for (String arrival : edges.get(vertices.indexOf(departure))) {
            ArrayList<ArrayList<String>> temp = new ArrayList<>();
            for (int i = 0; i < edges.size(); i++) {
                temp.add(new ArrayList<>());
                for (int j = 0; j < edges.get(i).size(); j++) temp.get(i).add(edges.get(i).get(j));
            }
            temp.get(vertices.indexOf(departure)).remove(arrival);
            LinkedList<String> path = findPath(vertices, temp, arrival, length - 1);
            if (path.size() == length) {
                path.addFirst(departure);
                return path;
            }
        }
        return new LinkedList<>();
    }
}