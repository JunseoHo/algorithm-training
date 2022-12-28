class Solution {
    public String solution(int[] food) {
       String left = "";
        String right = "";
        int foodNumber = 0;
        int[] var4 = food;
        int var5 = food.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            int i = var4[var6];
            if (i >= 2) {
                int j = i % 2 == 1 ? (i - 1) / 2 : i / 2;

                for(int k = 0; k < j; ++k) {
                    left = left + foodNumber;
                    right = "" + foodNumber + right;
                }
            }

            ++foodNumber;
        }

        return left + "0" + right;
    }
}