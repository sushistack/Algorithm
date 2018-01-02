import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CF20C {
    static int n, m, u, v, w;
    static String[] ins;
    static int[] dist = new int[100001];
    static int[] prev = new int[100001];
    static ArrayList<Edge>[] graph = new ArrayList[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            u = Integer.parseInt(ins[0]);
            v = Integer.parseInt(ins[1]);
            w = Integer.parseInt(ins[2]);
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        dijkstra();

        StringBuffer sb = new StringBuffer();
        int cur = n, i = 0;
        int[] ans = new int[n];
        if (dist[n] != Integer.MAX_VALUE) {
            ans[i++] = cur;
            while (cur != 1) {
                ans[i++] = cur = prev[cur];
            }
            for (int j = i - 1; j > -1; j--) {
                sb.append((j > 0) ? ans[j] + " " : ans[j]);
            }

        }else {
            sb.append("-1");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }

    public static void dijkstra() {
        boolean[] v = new boolean[100001];
        dist[1] = 0;prev[1] = 0;v[1] = true;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, dist[1]));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            v[cur.v] = true;
            for (int i = 0; i < graph[cur.v].size(); i++) {
                int to ,cost;
                to = graph[cur.v].get(i).v;
                cost = graph[cur.v].get(i).w;
                if (!v[to] && dist[to] > dist[cur.v] + cost) {
                    dist[to] = dist[cur.v] + cost;
                    prev[to] = cur.v;
                    pq.offer(new Edge(to, dist[to]));
                }

            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int v, w;
        Edge(int v, int w) {
            this.v = v; this.w = w;
        }
        @Override
        public int compareTo(Edge e) {
            return this.w > e.w ? 1 : -1;
        }
    }
}
