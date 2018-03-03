import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SWE1251 {
    static int t, T, n, x[] = new int[1001], y[] = new int[1001], uf[] = new int[1001], count;
    static double e;
    static String ins[];
    static Point[] ps;
    static long min;
    static ArrayList<Edge> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            ps = new Point[n];min = Long.MAX_VALUE;
            edges = new ArrayList<>();Arrays.fill(uf, -1);
            ins = br.readLine().split(" ");
            for (int i = 0; i < n; i++) x[i] = Integer.parseInt(ins[i]);
            ins = br.readLine().split(" ");
            for (int i = 0; i < n; i++) y[i] = Integer.parseInt(ins[i]);
            for (int i = 0; i < n; i++) {
                ps[i] = new Point(x[i], y[i]);
            }
            e = Double.parseDouble(br.readLine());

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    long w = (long)(Math.pow(ps[i].x - ps[j].x , 2) +
                            Math.pow(ps[i].y - ps[j].y , 2));
                    edges.add(new Edge(i, j, w));
                }
            }
            Collections.sort(edges);
            long ans = 0;count = 0;
            for (int i = 0; ; i++) {
                if (merge(edges.get(i).u, edges.get(i).v)) {
                    ans += edges.get(i).w;
                    if (++count == n - 1) break;
                }
            }
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(String.format("%.0f", ans * e));sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static void kruskal() {

    }

    public static int find(int a){
        if(uf[a] < 0) return a;
        return uf[a] = find(uf[a]);
    }

    public static boolean merge(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        uf[b] = a;
        return true;
    }

    private static class Edge implements Comparable<Edge> {
        int u, v;
        long w;
        Edge(int u, int v, long w) {
            this.u = u;this.v = v;this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.w > o.w ? 1 : (this.w == o.w ? 0 : -1);
        }
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
