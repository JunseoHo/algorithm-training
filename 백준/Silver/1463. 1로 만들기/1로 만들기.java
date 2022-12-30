import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] countTable;

    public static void main(String[] args) throws IOException {
        init();
        bw.write(calc(N, 0) + "\n");
        close();
    }

    public static int calc(int n, int count) throws IOException {
        if (n == 1) return count;
        if (countTable[n] != 0 && countTable[n] < count) return countTable[n];
        int min = Integer.MAX_VALUE;
        if (n % 3 == 0) min = Math.min(min, calc(n / 3, count + 1));
        if (n % 2 == 0) min = Math.min(min, calc(n / 2, count + 1));
        min = Math.min(min, calc(n - 1, count + 1));
        countTable[n] = min;
        return min;
    }


    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        countTable = new int[N + 1];
        Arrays.fill(countTable, 0);
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}