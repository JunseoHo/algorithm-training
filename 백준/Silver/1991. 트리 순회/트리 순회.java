import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] vars = br.readLine().split(" ");
            String key = vars[0];
            String left = vars[1].equals(".") ? null : vars[1];
            String right = vars[2].equals(".") ? null : vars[2];
            map.put(key, new Node(key, left, right));
        }
    }

    public static void solve() throws IOException {
        bw.write(preorder("A") + "\n");
        bw.write(inorder("A") + "\n");
        bw.write(postorder("A") + "\n");
    }

    public static String preorder(String key) {
        if (key != null) {
            Node node = map.get(key);
            return key + preorder(node.left) + preorder(node.right);
        } else return "";
    }

    public static String inorder(String key) {
        if (key != null) {
            Node node = map.get(key);
            return inorder(node.left) + key + inorder(node.right);
        } else return "";
    }

    public static String postorder(String key) {
        if (key != null) {
            Node node = map.get(key);
            return postorder(node.left) + postorder(node.right) + key;
        } else return "";
    }

    static class Node {
        String key;
        String left;
        String right;

        public Node(String c, String l, String r) {
            key = c;
            left = l;
            right = r;
        }
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // Variables
    static int N;
    static Map<String, Node> map;

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }

}