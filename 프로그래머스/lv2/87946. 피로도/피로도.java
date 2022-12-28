class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k) {
                if (dungeons.length == 1) return 1;
                int[][] dungeons2 = new int[dungeons.length - 1][2];
                int idx = 0;
                for (int j = 0; j < dungeons.length; j++) if (j != i) dungeons2[idx++] = dungeons[j];
                int count = 1 + solution(k - dungeons[i][1], dungeons2);
                if (count > answer) answer = count;
            }
        }
        return answer;
    }
}