import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int L;
    static int N;
    static List<String> words;
    static List<Integer> square;

    public static void init() throws IOException {
        String[] values = br.readLine().split(" ");
        L = Integer.parseInt(values[0]);
        N = Integer.parseInt(values[1]);
        words = new ArrayList<>(N);
        for (int i = 0; i < N; i++)
            words.add(br.readLine());
        Collections.sort(words);
        square = new LinkedList<>();
    }

    public static void solve() throws IOException {
        findSquare();
        if (square.size() == 0)
            System.out.println("NONE");
        else {
            for (int i : square)
                System.out.println(words.get(i));
        }
    }

    public static int findSquare() {
        int index = square.size();
        if (index == L) {
            return 1;
        }
        for (int i = 0; i < N; i++) {
            if (square.contains(i)) continue;
            boolean isOk = true;
            for (int j = 0; j < index; j++) {
                if (words.get(square.get(j)).charAt(index) != words.get(i).charAt(j)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                square.add(i);
                if (findSquare() == 1)
                    return 1;
                square.remove(square.size() - 1);
            }
        }
        return 0;
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