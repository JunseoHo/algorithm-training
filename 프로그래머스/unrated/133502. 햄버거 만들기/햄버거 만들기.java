class Solution {
    
    public int solution(int[] ingredient) {
     int answer = 0;
        int[] hamburger = {1, 2, 3, 1};
        int[] stack = new int[ingredient.length];
        int topIndex = -1;
        for (int i = 0; i < ingredient.length; i++) {
            stack[++topIndex] = ingredient[i];
            if (topIndex > 2) {
                boolean isHamburger = true;
                for (int j = 3; j > -1; j--)
                    if (stack[topIndex - j] != hamburger[3 - j]) isHamburger = false;
                if (isHamburger) {
                    answer++;
                    topIndex -= 4;
                }
            }
        }
        return answer;
    }
}