import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dictA = new HashMap<>();
        dictB = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            dictA.put(i + 1, name);
            dictB.put(name, i + 1);
        }
    }

    public static void solve() throws IOException {
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            try {
                int num = Integer.parseInt(question);
                bw.write(dictA.get(num) + "\n");
            } catch (NumberFormatException e) {
                bw.write(dictB.get(question) + "\n");
            }
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static int M;
    static Map<Integer, String> dictA;
    static Map<String, Integer> dictB;

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