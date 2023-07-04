import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int N;
    static int order;
    static LinkedList<Integer> num;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        order = 0;
        num = new LinkedList<>();
        num.add(0);
    }

    public static void solve() throws IOException {
        for (; order < N; order++) {
            num.set(0, num.get(0) + 1);
            carry(num, 0);
            for (int i = 0; i < num.size() - 1; i++) {
                if (num.get(i) >= num.get(i + 1)) {
                    num.set(i + 1, num.get(i) + 1);
                    if (i != 0) {
                        num.set(i, num.get(i - 1) + 1);
                    } else {
                        num.set(i, 0);
                    }
                }
            }
            carry(num, 0);
            for (int i = 0; i < num.size() - 1; i++) {
                if (num.get(i) >= num.get(i + 1)) {
                    num.set(i + 1, num.get(i) + 1);
                    if (i != 0) {
                        num.set(i, num.get(i - 1) + 1);
                    } else {
                        num.set(i, 0);
                    }
                }
            }
        }
        if (isDecreasing(num))
            System.out.println(toNumber(num));
        else
            System.out.println(-1);
    }

    public static boolean isDecreasing(LinkedList<Integer> num) {
        for (int i = 0; i < num.size() - 1; i++) {
            if (num.get(i) >= num.get(i + 1) || num.get(i + 1) > 9)
                return false;
        }
        return true;
    }


    public static void carry(LinkedList<Integer> num, int index) {
        if (index == num.size() - 1) {
            if (num.get(index) == 10) {
                num.set(index, 0);
                num.add(1);
            }
        } else {
            if (num.get(index) == 10) {
                num.set(index, 0);
                num.set(index + 1, num.get(index + 1) + 1);
            }
            carry(num, index + 1);
        }
    }

    public static long toNumber(LinkedList<Integer> num) {
        long number = 0;
        int index = num.size() - 1;
        while (index > -1) {
            number = number * 10 + num.get(index);
            --index;
        }
        return number;
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }
}
