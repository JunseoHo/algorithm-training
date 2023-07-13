import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {

    static class Node {
        int data;
        int leftIndex;
        int rightIndex;
        int parentIndex;

        public Node(int data) {
            this.data = data;
            this.leftIndex = -1;
            this.rightIndex = -1;
            this.parentIndex = -1;
        }

    }

    static List<Node> arr;

    public static void init() throws IOException {
        arr = new ArrayList<>();
        String input = "";
        while ((input = br.readLine()) != null)
            arr.add(new Node(Integer.parseInt(input)));
    }

    public static void traverse(int node) throws IOException {
        if (node == -1) return;
        traverse(arr.get(node).leftIndex);
        traverse(arr.get(node).rightIndex);
        bw.write(arr.get(node).data + "\n");
    }

    public static void solve() throws IOException {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1).data < arr.get(i).data && arr.get(i + 1).parentIndex == -1) {
                arr.get(i).leftIndex = i + 1;
                arr.get(i + 1).parentIndex = i;
            }
            int j = i + 1;
            for (; j < arr.size(); j++)
                if (arr.get(j).data > arr.get(i).data) break;
            if (j < arr.size() && arr.get(j).parentIndex == -1) {
                arr.get(i).rightIndex = j;
                arr.get(j).parentIndex = i;
            }
        }
        traverse(0);
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
