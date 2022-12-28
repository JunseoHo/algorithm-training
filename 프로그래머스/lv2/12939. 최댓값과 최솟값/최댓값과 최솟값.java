class Solution {
    public String solution(String s) {
         String[] numbers = s.split(" ");
        int maximum = Integer.parseInt(numbers[0]);
        int minimum = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (number > maximum) maximum = number;
            else if (number < minimum) minimum = number;
        }
        return minimum + " " + maximum;
    }
}