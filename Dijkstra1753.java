import java.lang.reflect.Array;
import java.util.*;

public class Dijkstra1753 {
    static int V, E, u, v, w, s;
    static ArrayList<Edge>[] list = new ArrayList[300001];
    static int[] distances = new int[20001];
    static boolean[] visit = new boolean[20001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();E = sc.nextInt();s = sc.nextInt();
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distances, 10000000);
        for (int i = 0; i < E; i++) {
            u = sc.nextInt();v = sc.nextInt();
            w = sc.nextInt();list[u].add(new Edge(v, w));
        }
        dijkstra(s);
        for (int i = 1; i <= V; i++) {
            System.out.println((distances[i] < 10000000) ? distances[i] : "INF");
        }

    }
    public static void dijkstra(int v) {
        Queue<Edge> q = new PriorityQueue<>();distances[s] = 0;
        q.offer(new Edge(s, distances[s]));
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            visit[cur.v] = true;
            for (int i = 0; i < list[cur.v].size(); i++) {
                int to = list[cur.v].get(i).v;
                int cost = list[cur.v].get(i).w;
                if (!visit[to] && distances[to] > distances[cur.v] + cost) {
                    distances[to] = distances[cur.v] + cost;
                    q.offer(new Edge(to, distances[to]));
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
            return w < e.w ? -1 : 1;
        }
    }
}
