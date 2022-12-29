import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] limit;
    static int M;
    static int[] weight;
    static int[] assigned;
    static int maxAssigned;

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(limit);
        Arrays.sort(weight);
        for (int i = M - 1; i > -1; i--) {
            int box = weight[i];
            boolean isAssigned = false;
            for (int j = 0; j < N; j++) {
                if (box <= limit[j]) {
                    if (assigned[j] == maxAssigned) {
                        for (int k = j + 1; k < N; k++) {
                            if (assigned[k] < maxAssigned) {
                                assigned[k]++;
                                isAssigned = true;
                                break;
                            }
                        }
                        if (!isAssigned) {
                            assigned[j]++;
                            isAssigned = true;
                            maxAssigned++;
                        }
                    } else {
                        assigned[j]++;
                        isAssigned = true;
                        break;
                    }
                    break;
                }
            }
            if (!isAssigned) {
                maxAssigned = -1;
                break;
            }
        }
        bw.write(String.valueOf(maxAssigned));
        br.close();
        bw.close();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        limit = new int[N];
        for (int i = 0; i < N; i++) limit[i] = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());
        weight = new int[M];
        for (int i = 0; i < M; i++) weight[i] = Integer.parseInt(tokenizer.nextToken());
        assigned = new int[N];
        Arrays.fill(assigned, 0);
        maxAssigned = 0;

    }


}