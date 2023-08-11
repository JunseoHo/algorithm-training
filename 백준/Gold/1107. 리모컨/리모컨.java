import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int channel;
    static int N;
    static List<Integer> buttons;


    public static void init() throws IOException {
        channel = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        buttons = new ArrayList<>();
        if (N != 0) {
            String values[] = br.readLine().split(" ");
            for (int i = 0; i < N; i++) buttons.add(Integer.valueOf(values[i]));
        }
    }

    static boolean check(int channel) {
        do {
            int digit = channel % 10;
            for (int btn : buttons) if (digit == btn) return true;
            channel /= 10;
        } while (channel > 0);
        return false;
    }

    static int findUpperBound(int channel) {
        if (buttons.size() == 0) return channel;
        while (check(channel)) {
            if (channel == 1000000) return channel;
            ++channel;
        }
        return channel;
    }

    static int findLowerBound(int channel) {
        if (buttons.size() == 0) return channel;
        while (check(channel)) {
            if (channel == -1) return channel;
            --channel;
        }
        return channel;
    }

    static int digit(int channel) {
        int digit = 0;
        do {
            ++digit;
            channel /= 10;
        } while (channel > 0);
        return digit;
    }

    public static void solve() throws IOException {
        int upperBound = findUpperBound(channel);
        int lowerBound = findLowerBound(channel);
        int noBound = (Math.abs(100 - channel));
        if (lowerBound == -1) lowerBound = 1000000;
        int fromUpperBound = digit(upperBound) + (Math.abs(upperBound - channel));
        int fromLowerBound = digit(lowerBound) + (Math.abs(lowerBound - channel));
        bw.write(String.valueOf(Math.min(noBound, Math.min(fromUpperBound, fromLowerBound))));
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
