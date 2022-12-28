class Solution {
   public static int[] solution(int[][] arr) {
        return solution(arr, 0, 0, arr.length);
    }

    public static int[] solution(int[][] arr, int row, int col, int len) {
        int sum = 0;
        for (int i = row; i < row + len; i++)
            for (int j = col; j < col + len; j++) sum += arr[i][j];
        if (sum == len * len) return new int[]{0, 1};
        else if (sum == 0) return new int[]{1, 0};
        else {
            int[] answer = {0, 0};
            int[] firstQuadrant = solution(arr, row, col + (len / 2), len / 2);
            int[] secondQuadrant = solution(arr, row, col, len / 2);
            int[] thirdQuadrant = solution(arr, row + (len / 2), col, len / 2);
            int[] fourthQuadrant = solution(arr, row + (len / 2), col + (len / 2), len / 2);
            for (int i = 0; i < 2; i++)
                answer[i] = firstQuadrant[i] + secondQuadrant[i] + thirdQuadrant[i] + fourthQuadrant[i];
            return answer;
        }
    }
}