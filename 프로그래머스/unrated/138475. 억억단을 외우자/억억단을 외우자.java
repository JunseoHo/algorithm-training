class Solution {
    public int[] solution(int e, int[] starts) {
      int[] answer = new int[starts.length];
        int[] counts = new int[e + 1];
        int[] maxCountTable = new int[e + 1];
        for (int i = 1; i < counts.length; i++)
            for (int j = 1; j <= e / i; j++) counts[i * j]++;
        int maxCount = 0;
        int maxIndex = 0;
        for (int k = e; k > 0; k--) {
            maxIndex = maxCount > counts[k] ? maxIndex : k;
            maxCount = Math.max(maxCount, counts[k]);
            maxCountTable[k] = maxIndex;
        }
        for (int i = 0; i < starts.length; i++) answer[i] = maxCountTable[starts[i]];
        return answer;
    }
}