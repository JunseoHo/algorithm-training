class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
      int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int element = 1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) matrix[i][j] = element++;
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int min = Integer.MAX_VALUE;
            int origin = matrix[x1][y1];
            for (int j = x1; j < x2; j++) {
                min = Math.min(matrix[j][y1], min);
                matrix[j][y1] = matrix[j + 1][y1];
            }
            for (int j = y1; j < y2; j++) {
                min = Math.min(matrix[x2][j], min);
                matrix[x2][j] = matrix[x2][j + 1];
            }
            for (int j = x2; j > x1; j--) {
                min = Math.min(matrix[j][y2], min);
                matrix[j][y2] = matrix[j - 1][y2];
            }
            for (int j = y2; j > y1; j--) {
                min = Math.min(matrix[x1][j], min);
                matrix[x1][j] = matrix[x1][j - 1];
            }
            matrix[x1][y1 + 1] = origin;
            answer[i] = min;
        }
        return answer;
    }
}