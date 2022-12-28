import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[6];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) numbers[i] = Integer.parseInt(tokenizer.nextToken());
        long answer = 0;
        if (N == 1) {
            int max = Integer.MIN_VALUE;
            for (int num : numbers) {
                max = Math.max(max, num);
                answer += num;
            }
            answer -= max;
        } else {
            // one plane
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++) min = Math.min(min, numbers[i]);
            answer += min * (5 * Math.pow(N, 2) + (-16) * N + 12);
            // two planes
            min = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++)
                for (int j = 0; j < 6; j++)
                    if (j != i && j != 5 - i) min = Math.min(min, numbers[i] + numbers[j]);
            answer += min * (8 * N - 12);
            // three planes
            min = Integer.MAX_VALUE;
            int[][] adj = {{1, 2, 4, 3}, {0, 2, 5, 3}, {0, 1, 5, 4}, {0, 1, 5, 4}, {0, 2, 5, 3}, {1, 2, 4, 3}};
            for (int i = 0; i < 6; i++) {
                min = Math.min(min, numbers[i] + numbers[adj[i][0]] + numbers[adj[i][1]]);
                min = Math.min(min, numbers[i] + numbers[adj[i][1]] + numbers[adj[i][2]]);
                min = Math.min(min, numbers[i] + numbers[adj[i][2]] + numbers[adj[i][3]]);
                min = Math.min(min, numbers[i] + numbers[adj[i][3]] + numbers[adj[i][0]]);
            }
            answer += min * 4;
        }
        System.out.println(answer);
        br.close();
        bw.close();
    }
}