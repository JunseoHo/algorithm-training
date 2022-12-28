import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] matrix;

    public static void main(String[] args) throws IOException {
        int input = Integer.parseInt(br.readLine());
        matrix = new boolean[input][input];
        drawMatrix(0, 0, input);
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++)
                bw.write(matrix[i][j] ? "*" : " ");
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static void drawMatrix(int row, int col, int input) {
        if (input < 3) return;
        if (input < 9) {
            matrix[row][col] = true;
            matrix[row][col + 1] = true;
            matrix[row][col + 2] = true;
            matrix[row + 1][col + 2] = true;
            matrix[row + 2][col + 2] = true;
            matrix[row + 2][col + 1] = true;
            matrix[row + 2][col] = true;
            matrix[row + 1][col] = true;
        } else {
            int distance = input / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!(i == 1 && j == 1))
                        drawMatrix(row + distance * j, col, distance);
                }
                col += distance;
            }
        }

    }


}