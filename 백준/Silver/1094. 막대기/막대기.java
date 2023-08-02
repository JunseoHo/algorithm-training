import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int X;
    static List<Integer> sticks;

    public static void init() throws IOException {
        X = Integer.parseInt(br.readLine());
        sticks = new ArrayList<>();
        sticks.add(64);
    }

    public static int getMin() {
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < sticks.size(); i++) {
            if (sticks.get(i) < minValue) {
                minValue = sticks.get(i);
                minIndex = i;
            }
        }
        sticks.remove(minIndex);
        return minValue;
    }

    public static int getSum() {
        int sum = 0;
        for (int stick : sticks)
            sum += stick;
        return sum;
    }

    public static void solve() throws IOException {
        while (getSum() > X) {
            int stick = getMin() >> 1;
            if (getSum() + stick < X)
                sticks.add(stick);
            sticks.add(stick);
        }
        bw.write(String.valueOf(sticks.size()));
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
