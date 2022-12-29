import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] charArr;

    public static void main(String[] args) throws IOException {
        init();

        List<Character> charTable = new ArrayList<>();
        List<Integer> charCount = new ArrayList<>();
        for (char c : charArr) {
            c = Character.toUpperCase(c);
            if (!charTable.contains(c)) {
                charTable.add(c);
                charCount.add(0);
            } else {
                int idx = charTable.indexOf(c);
                int count = charCount.get(idx);
                charCount.set(idx, count + 1);
            }
        }
        int maxCount = -1;
        int maxIdx = -1;
        for (int i = 0; i < charCount.size(); i++) {
            int count = charCount.get(i);
            if (count > maxCount) {
                maxCount = count;
                maxIdx = i;
            }
        }
        boolean isDuplicated = false;
        for (int i = 0; i < charCount.size(); i++) {
            int count = charCount.get(i);
            if (count == maxCount && i != maxIdx) {
                bw.write("?");
                isDuplicated = true;
                break;
            }
        }
        if (!isDuplicated) bw.write(charTable.get(maxIdx));
        close();
    }

    public static void init() throws IOException {
        charArr = br.readLine().toCharArray();
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}