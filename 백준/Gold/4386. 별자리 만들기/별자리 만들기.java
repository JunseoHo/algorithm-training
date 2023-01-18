import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // Variables
    static int N;
    static double[][] stars;
    static List<Edge> edges;

    static class Edge {
        int v;
        int u;
        double dist;

        public Edge(int v, int u, double dist) {
            this.v = v;
            this.u = u;
            this.dist = dist;
        }
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        stars = new double[N][2];
        for (int i = 0; i < N; i++) {
            String[] vars = br.readLine().split(" ");
            stars[i][0] = Double.parseDouble(vars[0]);
            stars[i][1] = Double.parseDouble(vars[1]);
        }
        edges = new LinkedList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = Math.sqrt(Math.pow((stars[i][0] - stars[j][0]), 2) + Math.pow((stars[i][1] - stars[j][1]), 2));
                edges.add(new Edge(i, j, dist));
            }
        }
    }

    public static void solve() throws IOException {
        double answer = 0;
        quickSort(edges);
        int[] parent = new int[N];
        int root = edges.get(0).v;
        for (int i = 0; i < N; i++) parent[i] = i;
        for (Edge edge : edges) {
            int v = edge.v;
            int u = edge.u;
            double dist = edge.dist;
            if (parent[v] != parent[u]) {
                if (v < u) {
                    int p = parent[u];
                    for (int i = 0; i < N; i++) {
                        if (parent[i] == p) parent[i] = parent[v];
                    }
                } else {
                    int p = parent[v];
                    for (int i = 0; i < N; i++) {
                        if (parent[i] == p) parent[i] = parent[u];
                    }
                }
                answer += dist;
            }
        }
        System.out.println(answer);
    }

    public static void quickSort(List<Edge> arr) {
        sort(arr, 0, arr.size() - 1);
    }

    private static void sort(List<Edge> arr, int low, int high) {
        if (low >= high) return;
        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(List<Edge> arr, int left, int right) {
        Edge pivot = arr.get((left + right) / 2);
        while (left <= right) {
            while (arr.get(left).dist < pivot.dist) left++;
            while (arr.get(right).dist > pivot.dist) right--;
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(List<Edge> arr, int i, int j) {
        Edge tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
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