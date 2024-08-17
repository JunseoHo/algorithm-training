class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {1, 2147483647};
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while (left < sequence.length - 1 || right < sequence.length - 1) {
            if (sum == k) {
                if (answer[1] - answer[0] > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                }
                if (right == sequence.length - 1) {
                    sum -= sequence[left];
                    left++;
                } else {
                    right++;
                    sum += sequence[right];
                }
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else {
                if (right == sequence.length - 1) {
                    sum -= sequence[left];
                    left++;
                } else {
                    right++;
                    sum += sequence[right];
                }
            }
        }
        if (sum == k) {
            if (answer[1] - answer[0] > right - left) {
                answer[0] = left;
                answer[1] = right;
            }
        }
        return answer;
    }
}