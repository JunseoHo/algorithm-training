import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
         int answer = 0;
        int[] sizeTable = new int[10_000_000];
        for (int i = 0; i < sizeTable.length; i++) sizeTable[i] = 0;
        for (int t : tangerine) sizeTable[t - 1]++;
        Arrays.sort(sizeTable);
        int loaded = 0;
        for (int i = sizeTable.length - 1; i > -1; i--) {
            answer++;
            if (loaded + sizeTable[i] >= k) break;
            else loaded += sizeTable[i];
        }
        return answer;
    }
}