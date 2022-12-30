import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] testCases;
    static int dpTable[];

    public static void main(String[] args) throws IOException {
        init();
        for (int testCase : testCases) {
            dpTable = new int[testCase + 1];
            Arrays.fill(dpTable, -1);
            bw.write(divide(testCase) + "\n");
        }
        close();
    }

    public static int divide(int n) {
        if (dpTable[n] != -1) return dpTable[n];
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int count = divide(n - 1);
        count += divide(n - 2);
        count += divide(n - 3);
        return dpTable[n] = count;
    }


    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        testCases = new int[N];
        for (int i = 0; i < N; i++) testCases[i] = Integer.parseInt(br.readLine());
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}