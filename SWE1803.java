import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWE1803 {
    static int t, T, n, m, a, b, u, v, w;
    static long[] d = new long[100001];
    static boolean[] vis = new boolean[100001];
    static ArrayList<Edge>[] g = new ArrayList[300001];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        for (int i = 1; i < 300001; i++) g[i] = new ArrayList<>();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);m = Integer.parseInt(ins[1]);
            a = Integer.parseInt(ins[2]);b = Integer.parseInt(ins[3]);
            for (int i = 1; i <= n; i++) g[i].clear();
            Arrays.fill(d, Long.MAX_VALUE);Arrays.fill(vis, false);
            for (int i = 0; i < m; i++) {
                ins = br.readLine().split(" ");
                u = Integer.parseInt(ins[0]);
                v = Integer.parseInt(ins[1]);
                w = Integer.parseInt(ins[2]);
                g[u].add(new Edge(v, w));
                g[v].add(new Edge(u, w));
            }
            dijkstra(a);

            bw.write("#" + (t - T) + " " + d[b] + " \n");
            bw.flush();
        }
        bw.close();
    }

    public static void dijkstra(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        d[s] = 0;pq.offer(new Edge(s, d[s]));
        vis[s] = true;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            vis[cur.v] = true;
            for (int i = 0; i < g[cur.v].size(); i++) {
                int to = g[cur.v].get(i).v;
                long c = g[cur.v].get(i).w;
                if (!vis[to] && d[to] > d[cur.v] + c) {
                    d[to] = d[cur.v] + c;
                    pq.offer(new Edge(to, d[to]));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge>{
        int v;
        long w;
        Edge(int v, long w) {
            this.v = v;this.w = w;
        }
        @Override
        public int compareTo(Edge e) {
            return w > e.w ? 1 : -1;
        }
    }
}
