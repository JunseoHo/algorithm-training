class Solution {
    public double[] solution(int k, int[][] ranges) {
         double[] answer = new double[ranges.length];
        int[] points = new int[1000];
        int index = 0;
        points[index++] = k;
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
                points[index] = k;
            } else {
                k = k * 3 + 1;
                points[index] = k;
            }
            index++;
        }
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int startX = range[0];
            int endX = (index - 1) + range[1];
            if(startX > endX){
                answer[i] = -1;
                continue;
            }
            double result = 0;
            for (; startX < endX; startX++) {
                int p = points[startX];
                int q = points[startX + 1];
                double rectangle = Math.max(p, q);
                double triangle = ((Math.abs(p - q)) / 2d);
                result += rectangle - triangle;
            }
            answer[i] = result;
        }
        return answer;
    }
}