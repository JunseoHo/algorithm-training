import java.io.*;
import java.util.*;

public class Main {

    // Variables
    static int N;

    static public class Node implements Comparable<Node> {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public void addChild(String[] names, int index) {
            if (index == names.length) return;
            String childName = names[index];
            Node node = getNode(childName);
            if (node == null) {
                node = new Node(childName);
                children.add(node);
            }
            node.addChild(names, index + 1);
            children.sort(null); // Sort the children alphabetically after adding a new node
        }

        public Node getNode(String name) {
            for (Node node : children)
                if (node.name.equals(name)) return node;
            return null;
        }

        @Override
        public int compareTo(Node other) {
            return this.name.compareTo(other.name);
        }
    }

    static Node root = new Node(null);

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] names = br.readLine().split(" ");
            root.addChild(names, 1);
        }
    }

    public static void solve(Node node, int depth) throws IOException {
        Collections.sort(node.children);
        if (depth != -1) {
            for (int i = 0; i < depth; i++) bw.write("--");
            bw.write(node.name + "\n");
        }
        for (Node child : node.children) solve(child, depth + 1);
    }

    public static void solve() throws IOException {
        solve(root, -1);
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

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