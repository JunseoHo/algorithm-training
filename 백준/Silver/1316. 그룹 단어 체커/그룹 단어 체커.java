import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            list = new ArrayList<>();
            char post = ' ';
            boolean isGroup = true;
            for (int j = 0; j < arr.length; j++) {
                if (post != arr[j] && !list.contains(arr[j])) {
                    list.add(arr[j]);
                    post = arr[j];
                } else if (post != arr[j] && list.contains(arr[j])) {
                    isGroup = false;
                    break;
                }
            }
            if (isGroup) answer++;
        }
        bw.write(String.valueOf(answer));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static ArrayList<Character> list;

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