import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static String[] p;
    static int n;
    static int[] sequence;

    public static void init() throws IOException {
        p = br.readLine().split("");
        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        str = str.substring(1, str.length() - 1);
        String[] seqStr = str.split(",");
        sequence = new int[n];
        for (int i = 0; i < n; i++) sequence[i] = Integer.parseInt(seqStr[i]);
    }

    public static void solve() throws IOException {
        boolean isReversed = false;
        int startIdx = 0;
        int endIdx = n == 0 ? -1 : n - 1;
        for (String f : p) {
            switch (f) {
                case "D":
                    if (startIdx > endIdx) {
                        bw.write("error\n");
                        return;
                    }
                    if (isReversed) endIdx--;
                    else startIdx++;
                    break;
                case "R":
                    isReversed = !isReversed;
                    break;
            }
        }
        bw.write("[");
        if (isReversed) {
            for (int i = endIdx; i >= startIdx; i--) {
                bw.write(String.valueOf(sequence[i]));
                if (i != startIdx) bw.write(",");
            }
        } else {
            for (int i = startIdx; i <= endIdx; i++) {
                bw.write(String.valueOf(sequence[i]));
                if (i != endIdx) bw.write(",");
            }
        }
        bw.write("]\n");
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
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init();
            solve();
        }
        close();
    }

}