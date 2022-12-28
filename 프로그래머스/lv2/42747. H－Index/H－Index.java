class Solution {
    public int solution(int[] citations) {
     Integer[] counts = new Integer[10001];
        for (int citation : citations) {
            if (counts[citation] == null) counts[citation] = 1;
            else counts[citation]++;
        }
        int paper = 0;
        for (int i = 10000; i > -1; i--) {
            if(counts[i] != null) paper += counts[i];
            if(paper >= i) return i;
        }
        return 0;
    }
}