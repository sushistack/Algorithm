import java.io.*;
import java.util.ArrayList;

public class SWE4253 {
    static int t, T, n, k, u, v;
    static ArrayList<Integer>[] tree = new ArrayList[100001];
    static ArrayList<Edge> edges = new ArrayList<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 100000; i++) tree[i] = new ArrayList<>();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            k = Integer.parseInt(ins[0]);
            for (int i = 0; i < 100000; i++) tree[i].clear();
            edges.clear();
            for (int i = 0; i < n; i++) {
                ins = br.readLine().split(" ");
                u = Integer.parseInt(ins[0]);
                v = Integer.parseInt(ins[1]);
                tree[u].add(v);tree[v].add(u);
                edges.add(new Edge(u, v));
            }
            // 각 노드별로 edge set과 길이를 가지고 있어야한다.
            // 트리니까 무조건 sortest path가 보장된다.

            for (int i = 0; i < k; i++) {

            }
        }

        bw.write(sb.toString());
        bw.flush();bw.close();
    }
    private static class Edge {
        int p, c;
        Edge(int p, int c) {
            this.p = p;this.c = c;
        }
    }


}
