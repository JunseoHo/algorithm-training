import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) bw.write(discriminate(br.readLine()) + "\n");
        br.close();
        bw.close();
    }

    public static String discriminate(String wave) {
        while (wave.length() != 0) {
            if (wave.startsWith("100")) {
                wave = wave.substring(3);
                while (wave.startsWith("0")) {
                    if (wave.length() > 1) wave = wave.substring(1);
                    else wave = "";
                }
                boolean isCompleted = false;
                while (wave.startsWith("1")) {
                    if (isCompleted && (wave.startsWith("100") || wave.startsWith("01"))) {
                        break;
                    } else {
                        if (wave.length() > 1) wave = wave.substring(1);
                        else wave = "";
                    }
                    isCompleted = true;
                }
                if (!isCompleted) return "NO";
            } else if (wave.startsWith("01")) {
                if (wave.length() == 2) wave = "";
                else wave = wave.substring(2);
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}