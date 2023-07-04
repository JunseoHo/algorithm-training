import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int x;
    static int size;
    static List<Integer> blocks;

    public static void init() throws IOException {

    }

    public static void solve() throws IOException {
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            x = Integer.parseInt(s) * 10000000;
            size = Integer.parseInt(br.readLine());
            blocks = new ArrayList<>();
            for (int i = 0; i < size; i++)
                blocks.add(Integer.valueOf(br.readLine()));
            int i = 0;
            int j = size - 1;
            Collections.sort(blocks);
            while (i < j) {
                if (blocks.get(i) + blocks.get(j) < x) i++;
                else if (blocks.get(i) + blocks.get(j) > x) j--;
                else if (blocks.get(i) + blocks.get(j) == x) {
                    System.out.println("yes " + blocks.get(i) + " " + blocks.get(j));
                    break;
                }
            }
            if (i >= j)
                System.out.println("danger");
        }
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
