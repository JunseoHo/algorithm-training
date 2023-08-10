import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int T;

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    public static void solve() throws IOException {
        for (int t = 0; t < T; t++) {
            int answer = 0;
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> gears = new HashMap<>();
            for (int n = 0; n < N; n++) {
                String gear = br.readLine().split(" ")[1];
                if (gears.containsKey(gear)) gears.replace(gear, gears.get(gear) + 1);
                else gears.put(gear, 1);
            }
            for (int g : gears.values())
                answer = answer == 0 ? g + 1 : answer * (g + 1);
            if (answer != 0) --answer;
            bw.write(answer + "\n");
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
