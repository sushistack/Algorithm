import java.io.*;
import java.util.ArrayList;

public class BellmanFord11657 {
    static int N, M;
    static String in[];
    static ArrayList<Edge>[] list = new ArrayList[6001];
    static int[] distances = new int[501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);M = Integer.parseInt(in[1]);
        for (int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < M; i++) {
            in = br.readLine().split(" ");
            list[Integer.parseInt(in[0])]
                    .add(new Edge(Integer.parseInt(in[1]),
                            Integer.parseInt(in[2])));
        }
    }
    public static void bellmanFord() {

    }

    private static class Edge {
        int v, w;
        Edge(int v, int w) {
            this.v = v; this.w = w;
        }
    }
}
