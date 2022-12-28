import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public static int[] solution(String[] grid) {
       int colCount = grid[0].split("").length;
        int rowCount = grid.length;
        String[][] nodeTable = new String[rowCount][colCount];
        boolean[][][] outgoingEdges = new boolean[rowCount][colCount][4];
        for (int i = 0; i < rowCount; i++) {
            String[] nodes = grid[i].split("");
            for (int j = 0; j < colCount; j++) nodeTable[i][j] = nodes[j];
        }
        ArrayList<Integer> lengthList = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                for (int k = 0; k < 4; k++) {
                    int length = -1;
                    if (!outgoingEdges[i][j][k]) {
                        outgoingEdges[i][j][k] = true;
                        int[] coordinate = {i, j};
                        int direction = k;
                        length = 0;
                        move(coordinate, rowCount, colCount, direction);
                        length++;
                        while (true) {
                            if (nodeTable[coordinate[0]][coordinate[1]].equals("L")) direction = direction == 0 ? 3 : direction - 1;
                            else if (nodeTable[coordinate[0]][coordinate[1]].equals("R")) direction = direction == 3 ? 0 : direction + 1;
                            if (((coordinate[0] == i && coordinate[1] == j) && (direction == k))) break;
                            outgoingEdges[coordinate[0]][coordinate[1]][direction] = true;
                            move(coordinate, rowCount, colCount, direction);
                            length++;
                        }
                    }
                    if (length != -1) lengthList.add(length);
                }
            }
        }
        int[] answer = new int[lengthList.size()];
        for(int i = 0; i < lengthList.size(); i++) answer[i] = lengthList.get(i);
        Arrays.sort(answer);
        return answer;
    }


    public static void move(int[] coordinate, int rowCount, int colCount, int direction) {
        if (direction == 0) {
            if (coordinate[0] == 0) coordinate[0] = rowCount - 1;
            else coordinate[0]--;
        } else if (direction == 1) {
            if (coordinate[1] == (colCount - 1)) coordinate[1] = 0;
            else coordinate[1]++;
        } else if (direction == 2) {
            if (coordinate[0] == (rowCount - 1)) coordinate[0] = 0;
            else coordinate[0]++;
        } else if (direction == 3) {
            if (coordinate[1] == 0) coordinate[1] = colCount - 1;
            else coordinate[1]--;
        }
    }
}