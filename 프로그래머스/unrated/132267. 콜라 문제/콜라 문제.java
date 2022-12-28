class Solution {
    public int solution(int a, int b, int n) {
          int answer = 0;
        if (n < a) return answer;
        int received = 0;
        while (n >= a) {
            n -= a;
            received += b;
        }
        return received + solution(a, b, received + n);
    }
}