import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
           int answer = 0;
        Integer[] toppingTable = new Integer[10001];
        int rightToppingTypeCount = 0;
        for (int t : topping) {
            if (toppingTable[t] == null) {
                toppingTable[t] = 1;
                rightToppingTypeCount++;
            } else toppingTable[t] += 1;
        }
        int leftToppingTypeCount = 0;
        boolean[] toppingIncluded = new boolean[10001];
        for (int i = 0; i < topping.length; i++) {
            if (toppingTable[topping[i]] != 0) {
                if (toppingIncluded[topping[i]] == false) leftToppingTypeCount++;
                toppingIncluded[topping[i]] = true;
                toppingTable[topping[i]] -= 1;
            }
            if (toppingTable[topping[i]] == 0) rightToppingTypeCount -= 1;
            if (leftToppingTypeCount == rightToppingTypeCount) answer++;
        }
        return answer;
    }
}