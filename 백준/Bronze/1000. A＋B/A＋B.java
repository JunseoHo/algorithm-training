import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String[] N;

    public static void main(String[] args) throws IOException {
        N = br.readLine().split(" ");
        bw.write(String.valueOf(Integer.parseInt(N[0]) + Integer.parseInt(N[1])));
        br.close();
        bw.close();
    }

}