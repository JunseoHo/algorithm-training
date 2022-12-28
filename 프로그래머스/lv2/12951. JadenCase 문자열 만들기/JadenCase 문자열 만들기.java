class Solution {
    public String solution(String s) {
     String answer = "";
        char[] charArr = s.toCharArray();
        boolean isPostBlank = true;
        for (char c : charArr) {
            if (c == ' ') {
                if (isPostBlank) answer += ' ';
                else {
                    isPostBlank = true;
                    answer += ' ';
                }
            } else {
                if (isPostBlank) {
                    isPostBlank = false;
                    if (c > 96 && c < 123) c -= 32;
                } else if (c > 64 && c < 91) c += 32;
                answer += c;
            }
        }
        return answer;
    }
}