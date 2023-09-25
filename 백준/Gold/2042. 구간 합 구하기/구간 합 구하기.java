import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        Node left;
        Node right;
        long value = 0;
    }

    static int N, M, K;
    static long[] arr;
    static Node root;

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());
        root = new Node();
        build(root, 0, N - 1);
    }

    public static void build(Node node, int start, int end) {
        if (start == end) {
            node.value = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(node.left = new Node(), start, mid);
            build(node.right = new Node(), mid + 1, end);
            node.value = node.left.value + node.right.value;
        }
    }

    public static long query(Node node, int left, int right, int start, int end) {
        if (node == null || left > end || right < start) return 0;
        if (left <= start && right >= end) return node.value;
        int mid = (start + end) / 2;
        long leftQueryResult = query(node.left, left, right, start, mid);
        long rightQueryResult = query(node.right, left, right, mid + 1, end);
        return leftQueryResult + rightQueryResult;
    }

    public static void update(Node node, int start, int end, int target, long diff) {
        if (node == null) return;
        if (target < start || target > end) return;
        node.value += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(node.left, start, mid, target, diff);
            update(node.right, mid + 1, end, target, diff);
        }
    }

    public static void solve() throws IOException {
        List<Long> answer = new ArrayList<>();
        for (int i = 0; i < M + K; i++) {
            String[] input = br.readLine().split(" ");
            int cmd = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            long b = Long.parseLong(input[2]);
            if (cmd == 1) {
                long diff = b - arr[--a];
                arr[a] = b;
                update(root, 0, N - 1, a, diff);
            } else if (cmd == 2) answer.add(query(root, --a, (int)--b, 0, N - 1));
        }
        for (long l : answer) bw.write(l + "\n");
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