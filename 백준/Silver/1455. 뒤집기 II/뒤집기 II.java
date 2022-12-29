import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++)
                matrix[i][j] = Integer.parseInt(row[j]);
        }
        bw.write(String.valueOf(reverse(matrix, 0)));
        br.close();
        bw.close();
    }

    public static int reverse(int[][] matrix, int count) {
        List<int[]> reversed = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (matrix[i][j] == 1) reversed.add(new int[]{i, j});
        }
        if (reversed.size() == 0) return count;
        else {
            int maxRow = 0;
            int maxCol = 0;
            int[] maxCo = {maxRow, maxCol};
            for (int[] co : reversed)
                if (co[0] >= maxRow && co[1] >= maxCol) {
                    maxCo = co;
                }
//            int reversible = 0;
//            int idx = 0;
//            for (int i = 0; i < reversed.size(); i++) {
//                int[] co = reversed.get(i);
//                int rev = 0;
//                for (int j = 0; j < reversed.size(); j++) {
//
//                    if (co[0] >= reversed.get(j)[0] && co[1] >= reversed.get(j)[1]) {
//                        rev++;
//                    }
//                }
//                if (rev > reversible) {
//                    reversible = rev;
//                    idx = i;
//                }
//            }
            for (int i = 0; i <= maxCo[0]; i++)
                for (int j = 0; j <= maxCo[1]; j++)
                    matrix[i][j] = matrix[i][j] == 0 ? 1 : 0;
            return reverse(matrix, count + 1);
        }
    }

}