import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        List<Integer> numOfHouse = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.parseInt(row[j]);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (matrix[i][j] == 1) {
                        Queue<int[]> que = new LinkedList<>();
                        que.add(new int[]{i, j});
                        int house = 0;
                        while (!que.isEmpty()) {
                            int[] coordinate = que.poll();
                            int coRow = coordinate[0];
                            int coCol = coordinate[1];
                            int row = coRow - 1;
                            int col = coCol;
                            if (row > -1 && matrix[row][col] == 1 && !visited[row][col]) {
                                que.add(new int[]{row, col});
                                visited[row][col] = true;
                            }
                            row = coRow;
                            col = coCol + 1;
                            if (col < N && matrix[row][col] == 1 && !visited[row][col]) {
                                que.add(new int[]{row, col});
                                visited[row][col] = true;
                            }
                            row = coRow + 1;
                            col = coCol;
                            if (row < N && matrix[row][col] == 1 && !visited[row][col]) {
                                que.add(new int[]{row, col});
                                visited[row][col] = true;
                            }
                            row = coRow;
                            col = coCol - 1;
                            if (col > -1 && matrix[row][col] == 1 && !visited[row][col]) {
                                que.add(new int[]{row, col});
                                visited[row][col] = true;
                            }
                            house++;
                        }
                        if (house != 1) house--;
                        numOfHouse.add(house);
                        answer++;
                    } else visited[i][j] = true;
                }
            }
        }
        bw.write(String.valueOf(answer) + "\n");
        Collections.sort(numOfHouse);
        for (int i : numOfHouse) bw.write(String.valueOf(i) + "\n");
        br.close();
        bw.close();
    }

}