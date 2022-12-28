import java.util.Arrays;
class Solution {
    public String solution(String X, String Y) {
          int[] numTableX = new int[10];
        int[] numTableY = new int[10];
        int[] commonNumTable = new int[10];
        Arrays.fill(numTableX, 0);
        Arrays.fill(numTableY, 0);
        for (String n : X.split("")) numTableX[Integer.parseInt(n)]++;
        for (String n : Y.split("")) numTableY[Integer.parseInt(n)]++;
        for (int i = 0; i < 10; i++) commonNumTable[i] = Math.min(numTableX[i], numTableY[i]);
        StringBuilder builder = new StringBuilder();
        boolean isFilledZero = true;
        for (int i = 9; i > -1; i--) {
            while (commonNumTable[i] > 0) {
                if (i > 0) isFilledZero = false;
                builder.append(i);
                commonNumTable[i]--;
            }
        }
        if (builder.toString().equals("")) return "-1";
        if (isFilledZero) return "0";
        return builder.toString();
    }
}