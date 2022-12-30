import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Set<Integer> S;

    public static void main(String[] args) throws IOException {
        init();


        close();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");
            int num = 0;
            if (cmd.length == 2)
                num = Integer.parseInt(cmd[1]);
            switch (cmd[0]) {
                case "add":
                    S.add(num);
                    break;
                case "remove":
                    S.remove(num);
                    break;
                case "check":
                    bw.write((S.contains(num) ? 1 : 0) + "\n");
                    break;
                case "toggle":
                    if (S.contains(num)) S.remove(num);
                    else S.add(num);
                    break;
                case "all":
                    for (int j = 1; j < 21; j++) S.add(j);
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}