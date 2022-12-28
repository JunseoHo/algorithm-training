import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) bw.write(s1(br.readLine()) + "\n");
        br.close();
        bw.close();
    }

    public static String s1(String wave) {
        if (wave.length() == 0) return "YES";
        if (wave.startsWith("100")) return s2(wave.substring(3));
        if (wave.startsWith("01")) return s1(wave.substring(2));
        return "NO";
    }


    public static String s2(String wave) {
        if (wave.startsWith("0")) return s2(wave.substring(1));
        if (wave.startsWith("1")) return s3(wave.substring(1));
        return "NO";
    }

    public static String s3(String wave) {
        if (wave.length() == 0) return s1(wave);
        if (wave.startsWith("100")) return s2(wave.substring(3));
        if (wave.startsWith("01")) return s1(wave.substring(2));
        if (wave.startsWith("1")) return s3(wave.substring(1));
        return "NO";
    }

}