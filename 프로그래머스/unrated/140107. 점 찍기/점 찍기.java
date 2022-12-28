class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            double x = 0;
            double y = 0;
            while (!(Math.sqrt(Math.pow(x + k, 2) + Math.pow(y, 2)) > d)) x += k;
            answer += (x / k) + 1;
            y += k;
            while (!(Math.sqrt(Math.pow(y, 2)) > d)) {
                if (!(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) > d)) {
                    answer += (x / k) + 1;
                    y += k;
                } else x -= k;
            }
            return answer;
        }
    }