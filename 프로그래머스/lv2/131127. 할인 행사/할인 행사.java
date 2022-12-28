class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
           int answer = 0;
        int[] purchase = new int[want.length];
        for (int p : purchase) p = 0;
        for (int i = 0; i < 10; i++) {
            String product = discount[i];
            for (int j = 0; j < want.length; j++)
                if (want[j].equals(product)) purchase[j]++;
        }
        for (int i = 0; i < discount.length - 9; i++) {
            boolean discountable = true;
            for (int j = 0; j < want.length; j++)
                if (purchase[j] < number[j]) discountable = false;
            if (discountable) answer++;
            String deleteProduct = discount[i];
            for (int j = 0; j < want.length; j++)
                if (want[j].equals(deleteProduct)) purchase[j]--;
            if (i != (discount.length - 10)) {
                String addProduct = discount[i + 10];
                for (int j = 0; j < want.length; j++)
                    if (want[j].equals(addProduct)) purchase[j]++;
            }
        }
        return answer;
    }
}