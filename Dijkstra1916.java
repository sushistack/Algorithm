import java.util.*;

public class Dijkstra1916 {
    static int N, M, u ,v ,w, s, e;
    static int[] d = new int[1001];
    static boolean[] visit = new boolean[1001];
    static ArrayList<Edge>[] list = new ArrayList[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(d, 1000000000);
        for (int i = 0; i < M; i++) {
            u = sc.nextInt();v = sc.nextInt();
            w = sc.nextInt();list[u].add(new Edge(v, w));
        }
        s = sc.nextInt(); e = sc.nextInt();
        dijkstra(s);
        System.out.println(d[e]);
    }
    public static void dijkstra(int v) {
        Queue<Edge> q = new PriorityQueue();d[s] = 0;
        q.offer(new Edge(s, d[s]));
        while (!q.isEmpty()) {
            Edge cur = q.poll();visit[cur.v] = true;
            for (int i = 0; i < list[cur.v].size(); i++) {
                int to = list[cur.v].get(i).v;
                int cost = list[cur.v].get(i).w;
                if (!visit[to] && d[to] > d[cur.v] + cost) {
                    d[to] = d[cur.v] + cost;
                    q.offer(new Edge(to, d[to]));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge>{
        int v, w;
        Edge(int v, int w) {
            this.v = v; this.w = w;
        }
        @Override
        public int compareTo(Edge e) {
            return (w < e.w) ? -1 : 1;
        }

    }
}
