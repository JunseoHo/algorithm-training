class Solution {
    public int solution(int k, int m, int[] score) {
      int answer = 0;
        int[] scoreTable = new int[k];
        for (int s : scoreTable) s = 0;
        for (int s : score) scoreTable[s - 1]++;
        int loaded = 0;
        for (int i = k - 1; i > -1; i--) {
            if (scoreTable[i] != 0) {
                if (loaded != 0) {
                    if(loaded + scoreTable[i] < m){
                        loaded += scoreTable[i];
                        scoreTable[i] = 0;
                        continue;
                    }else{
                        answer += (i + 1) * m;
                        scoreTable[i] -= m - loaded;
                        loaded = 0;
                    }
                }
                while (scoreTable[i] >= m) {
                    answer += (i + 1) * m;
                    scoreTable[i] -= m;
                }
                loaded = scoreTable[i];
            }
        }
        return answer;
    }
}