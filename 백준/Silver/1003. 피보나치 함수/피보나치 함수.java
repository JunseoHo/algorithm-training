import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<Integer> testCases;
    static Integer[][] fibonacciTable;
    static int numOfZero;
    static int numOfOne;

    public static void main(String[] args) throws IOException {
        init();
        for (int testCase : testCases) {
            fibonacciTable = new Integer[testCase + 1][2];
            Arrays.fill(fibonacciTable, null);
            Integer[] res = fibonacci(testCase);
            bw.write(res[0] + " " + res[1] + "\n");
        }
        close();
    }

    public static Integer[] fibonacci(int n) {
        if (fibonacciTable[n] != null) {
            return fibonacciTable[n];
        } else {
            if (n == 0) {
                fibonacciTable[0] = new Integer[]{1, 0};
                return fibonacciTable[0];
            } else if (n == 1) {
                fibonacciTable[1] = new Integer[]{0, 1};
                return fibonacciTable[1];
            } else {
                Integer[] res1 = fibonacci(n - 1);
                Integer[] res2 = fibonacci(n - 2);
                fibonacciTable[n] = new Integer[]{res1[0] + res2[0], res1[1] + res2[1]};
                return fibonacciTable[n];
            }
        }

    }

    public static void init() throws IOException {
        testCases = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) testCases.add(Integer.valueOf(br.readLine()));
        numOfZero = 0;
        numOfOne = 0;
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}