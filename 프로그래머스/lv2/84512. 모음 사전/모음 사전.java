class Solution {
    public int solution(String word) {
      int answer = 0;
        String[] codeTable = {"A", "E", "I", "O", "U"};
        String[] charArr = new String[5];
        String[] wordArr = word.split("");
        for (int i = 0; i < charArr.length; i++) charArr[i] = wordArr.length > i ? wordArr[i] : " ";
        for (int i = 0; i < 5; i++) {
            if (charArr[i].equals(" ")) break;
            int index = -1;
            for (int j = 0; j < 5; j++) if (codeTable[j].equals(charArr[i])) index = j;
            int weight = 1;
            for (int j = 4; j > i; j--) weight = weight * 5 + 1;
            answer += weight * index + 1;
        }
        return answer;
    }
}