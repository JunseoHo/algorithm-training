
import java.util.LinkedList;
class Solution {
   public static int solution(int[] queue1, int[] queue2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        for (int i : queue1) q1.add(i);
        for (int i : queue2) q2.add(i);
        long sumOfQ1 = 0;
        long sumOfQ2 = 0;
        for (int i : q1) sumOfQ1 += i;
        for (int i : q2) sumOfQ2 += i;
        long difference = sumOfQ1 - sumOfQ2;
        int workCount = 0;
        int limit = q1.size() * 4;
        while (workCount < limit) {
            if (difference == 0) return workCount;
            if (difference > 0) {
                int x = q1.removeFirst();
                q2.add(x);
                difference -= x * 2;
            } else {
                int x = q2.removeFirst();
                q1.add(x);
                difference += x * 2;
            }
            workCount++;
        }
        return -1;
    }

}