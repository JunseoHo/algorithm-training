import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static List<LinkedList<Integer>> gears;
    static int N;

    public static void init() throws IOException {
        gears = new ArrayList<>();
        for (int i = 0; i < 5; i++) gears.add(new LinkedList<>());
        for (int i = 1; i < 5; i++) {
            LinkedList<Integer> list = gears.get(i);
            for (String s : br.readLine().split("")) {
                list.add(Integer.valueOf(s));
            }
        }
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            String[] vars = br.readLine().split(" ");
            int rotateNumber = Integer.parseInt(vars[0]);
            int direction = Integer.parseInt(vars[1]);
            int[] rotateDirection = new int[5];
            Arrays.fill(rotateDirection, 0);
            rotateDirection[rotateNumber] = direction;
            for (int j = rotateNumber + 1; j < 5; j++) {
                LinkedList<Integer> back = gears.get(j);
                LinkedList<Integer> front = gears.get(j - 1);
                int frontTooth = front.get(2);
                int backTooth = back.get(6);
                if (frontTooth != backTooth) {
                    if (rotateDirection[j - 1] == 1) rotateDirection[j] = -1;
                    else rotateDirection[j] = 1;
                } else break;
            }
            for (int j = rotateNumber - 1; j > 0; j--) {
                LinkedList<Integer> front = gears.get(j);
                LinkedList<Integer> back = gears.get(j + 1);
                int frontTooth = front.get(2);
                int backTooth = back.get(6);
                if (frontTooth != backTooth) {
                    if (rotateDirection[j + 1] == 1) rotateDirection[j] = -1;
                    else rotateDirection[j] = 1;
                } else break;
            }
            for (int j = 1; j < 5; j++) {
                LinkedList<Integer> list = gears.get(j);
                if (rotateDirection[j] == 1) {
                    int tooth = list.removeLast();
                    list.addFirst(tooth);
                } else if (rotateDirection[j] == -1) {
                    int tooth = list.removeFirst();
                    list.addLast(tooth);
                }
            }
        }
        int answer = 0;
        if (gears.get(1).get(0) == 1) answer += 1;
        if (gears.get(2).get(0) == 1) answer += 2;
        if (gears.get(3).get(0) == 1) answer += 4;
        if (gears.get(4).get(0) == 1) answer += 8;
        bw.write(String.valueOf(answer));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }

}