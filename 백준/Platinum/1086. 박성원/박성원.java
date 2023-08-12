import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N, K;
    static List<List<Character>> numbers;
    static List<Integer> mods;
    static List<Integer> modOfTens;
    static long dpTable[][];
    static long q;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            List<Character> number = new ArrayList<>();
            for (char c : br.readLine().toCharArray()) number.add(c);
            numbers.add(number);
        }
        K = Integer.parseInt(br.readLine());
        mods = new ArrayList<>();
        for (int n = 0; n < N; n++) mods.add(modular(numbers.get(n), K));
        modOfTens = new ArrayList<>();
        modOfTens.add(1 % K);
        for (int n = 0; n < 51; n++) modOfTens.add(modOfTens.get(modOfTens.size() - 1) * 10 % K);
        q = 1;
        for (int i = 1; i <= N; i++) {
            q *= i;
        }
        int i = (int) Math.pow(2, N) + 1;
        int j = 101;
        dpTable = new long[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                dpTable[k][l] = -1;
            }
        }
    }

    public static int modular(List<Character> list, int k) {
        int mod = 0;
        for (char c : list) {
            mod *= 10;
            mod += c - '0';
            mod %= k;
        }
        return mod;
    }

    public static long solve(int stat, int mod) {
        if (stat == (Math.pow(2, N) - 1)) {
            if (mod == 0 || mod == K)
                return 1;
            else return 0;
        } else {
            long p = 0;
            for (int n = 0; n < N; n++) {
                if (((stat >> n) & 1) == 0) {
                    int newStat = stat | (1 << n);
                    int newMod = ((mod * modOfTens.get(numbers.get(n).size())) % K) + mods.get(n);
                    newMod %= K;
                    if (dpTable[newStat][newMod] == -1) {
                        long temp = solve(newStat, newMod);
                        dpTable[newStat][newMod] = temp;
                    }
                    p += dpTable[newStat][newMod];
                }
            }
            return p;
        }
    }


    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static void solve() throws IOException {
        long p = solve(0, 0);
        if (p == 0) bw.write("0/1");
        else {
            long gcd = gcd(p, q);
            bw.write((p / gcd) + "/" + (q / gcd));
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
