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
            for (int j = 0; j < input; j++) bw.write(matrix[i][j] ? "*" : " ");
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static void drawMatrix(int row, int col, int input) {
        if (input < 3) matrix[row][col] = true;
        else {
            int dist = input / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    if (!(i == 1 && j == 1)) drawMatrix(row + dist * j, col, dist);
                col += dist;
            }
        }
    }
}