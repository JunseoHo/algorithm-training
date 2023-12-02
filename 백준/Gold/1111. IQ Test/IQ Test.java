import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> numList;
    static int[] answer = null;

    public static boolean evaluate(int i, int a, int b) {
        if (i == numList.size() - 1) return true;
        if (numList.get(i) * a + b == numList.get(i + 1)) return evaluate(i + 1, a, b);
        return false;
    }

    public static void main(String[] args) throws IOException {
        // read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] values = br.readLine().split(" ");
        numList = new ArrayList<>();
        for (String s : values) numList.add(Integer.parseInt(s));
        // solve
        if (numList.size() == 1)
            System.out.println("A");
        else if (numList.size() == 2) {
            if (numList.get(0) == numList.get(1)) System.out.println(numList.get(0)); // What the fuck??
            else System.out.println("A");
        } else {
            int a;
            if (numList.get(0) == numList.get(1)) a = 0;
            else a = (numList.get(2) - numList.get(1)) / (numList.get(1) - numList.get(0));
            int b = numList.get(1) - (numList.get(0) * a);
            if (evaluate(0, a, b)) System.out.println(numList.get(N - 1) * a + b);
            else System.out.println("B");
        }
    }
}
