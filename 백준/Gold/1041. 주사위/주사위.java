import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dice = {{1, 2, 4, 3}, {0, 2, 5, 3}, {0, 1, 5, 4}, {0, 1, 5, 4}, {0, 2, 5, 3}, {1, 2, 4, 3}};

    public static void main(String[] args) throws IOException {
        // read input
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[6];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) numbers[i] = Integer.parseInt(tokenizer.nextToken());

        long answer = 0;

        if (N == 1) {
            for (int i : numbers)
                answer += i;
            int max = -1;
            for (int i : numbers) {
                max = Math.max(max, i);
            }
            answer -= max;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++)
                min = Math.min(min, numbers[i]);
            answer += min * (Math.pow(N, 2) * 5 + N * (-16) + 12);

            min = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++)
                    if (j != i && j != 5 - i)
                        min = Math.min(min, numbers[i] + numbers[j]);
            }

            answer += min * (8 * N - 12);
            min = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                int[] adj = dice[i];
                min = Math.min(min, numbers[i] + numbers[adj[0]] + numbers[adj[1]]);
                min = Math.min(min, numbers[i] + numbers[adj[1]] + numbers[adj[2]]);
                min = Math.min(min, numbers[i] + numbers[adj[2]] + numbers[adj[3]]);
                min = Math.min(min, numbers[i] + numbers[adj[3]] + numbers[adj[0]]);
            }
            answer += min * 4;
        }


        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }


}