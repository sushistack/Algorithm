import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWE1249 {
    final static int INF = Integer.MAX_VALUE;
    static int t, T, n, w;
    static int[] a = new int[1000001];
    static int[] d = new int[1000001];
    static boolean[] v = new boolean[1000001];
    static String in;
    static ArrayList<Edge>[] g = new ArrayList[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());T = t;
        for (int i = 0; i < 1000001; i++) {
            g[i] = new ArrayList<>();
        }
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < 1000001; i++) {
                g[i].clear();
            }
            Arrays.fill(a, 0);Arrays.fill(d, INF);
            for (int i = 0; i < n; i++) {
                in = br.readLine();
                for (int j = 0; j < n; j++) {
                    a[i * n + j] = in.charAt(j) - 48;
                }
            }
            int[] dx = {-1, 1, n, -n};
            for (int i = 0; i < n*n; i++) {
                for (int j = 0; j < 4; j++) {
                    int nx = i + dx[j];
                    if (i % n == 0 && j == 0) continue;
                    if(i % n == n - 1 && j == 1) continue;
                    if (nx < 0 || nx > n * n - 1) continue;
                    g[i].add(new Edge(nx, a[nx]));
                }
            }
            dijkstra();
            bw.write("#" + (t - T) + " " + d[n*n - 1] + "\n");bw.flush();
        }
        bw.close();
    }
    public static void dijkstra() {
        d[0] = 0;Arrays.fill(v, false);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        v[0] = true;
        pq.offer(new Edge (0, d[0]));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            v[cur.v] = true;
            for (int i = 0; i < g[cur.v].size(); i++) {
                int to = g[cur.v].get(i).v;
                int cost = g[cur.v].get(i).w;
                if (!v[to] && d[to] > d[cur.v] + cost) {
                    d[to] = d[cur.v] + cost;
                    pq.offer(new Edge(to, d[to]));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge>{
        int v, w;
        Edge(int v, int w) {
            this.v = v;this.w = w;
        }
        @Override
        public int compareTo(Edge e) {
            return w < e.w ? -1 : 1;
        }
    }
}
