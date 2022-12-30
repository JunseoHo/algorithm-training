import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] cumulativeCost;
    static int[][] costs;

    public static void main(String[] args) throws IOException {
        init();
        int answer = Integer.MAX_VALUE;
        answer = Math.min(answer, costs[0][0] + paint(1, 0));
        answer = Math.min(answer, costs[0][1] + paint(1, 1));
        answer = Math.min(answer, costs[0][2] + paint(1, 2));
        bw.write(answer + "\n");
        close();
    }

    public static int paint(int house, int postColor) {
        if (cumulativeCost[house][postColor] != -1) {
            return cumulativeCost[house][postColor];
        }
        if (house == N - 1) {
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++)
                if (i != postColor && minCost > costs[house][i])
                    minCost = costs[house][i];
            cumulativeCost[house][postColor] = minCost;
            return minCost;
        } else {
            int[] otherColors = new int[2];
            if (postColor == 0) otherColors = new int[]{1, 2};
            if (postColor == 1) otherColors = new int[]{0, 2};
            if (postColor == 2) otherColors = new int[]{0, 1};
            int minCost = costs[house][otherColors[0]] + paint(house + 1, otherColors[0]);
            minCost = Math.min(minCost, costs[house][otherColors[1]] + paint(house + 1, otherColors[1]));
            cumulativeCost[house][postColor] = minCost;
            return minCost;
        }
    }


    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        cumulativeCost = new int[N][3];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 3; j++) cumulativeCost[i][j] = -1;
        costs = new int[N][3];
        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(tokenizer.nextToken());
            int G = Integer.parseInt(tokenizer.nextToken());
            int B = Integer.parseInt(tokenizer.nextToken());
            costs[i] = new int[]{R, G, B};
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

}