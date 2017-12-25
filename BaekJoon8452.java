import java.util.*;

public class BaekJoon8452 {
    static int n, m, q, u, v, p;
    static char t;
    static HashMap<Integer, Integer>[] graph = new HashMap[100001];
    static Edge[] numOfEdge = new Edge[100001];
    static int[] distances = new int[100001];
    static int[] prev = new int[100001];
    static ArrayList<Integer>[] paths = new ArrayList[100001];
    static boolean[] visit = new boolean[100001];
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        n = sc.nextInt();m = sc.nextInt();q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashMap<>();
            paths[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            u = sc.nextInt(); v = sc.nextInt();
            numOfEdge[i + 1] = new Edge(u, v);graph[u].put(v, 1);
        }
        Arrays.fill(distances ,100000000);
        dijkstra();
        paths[1].add(0);
        for (int i = 2; i <= n; i++) {
            if (distances[i] != 100000000) {
                path(paths[i], i);
            }
        }
        for (int i = 0; i < q; i++) {
            t = sc.next().charAt(0);p = sc.nextInt();
            if (t == 'E') {
                System.out.println((distances[p] == 100000000) ? -1 : distances[p]);
            }else {
                Arrays.fill(visit ,false);
                Edge e = numOfEdge[p];graph[e.u].remove(e.v);
                for (int j = 2; j <= n; j++) {

                }
            }
        }

    }
    public static void path(ArrayList<Integer> list, int d) {
        while (true) {
            list.add(d);d = prev[d];
            if (d == 1) {list.add(d);break;}
        }
    }

    public static void dijkstra() {
        int s = 1; distances[s] = 0;visit[s] = true;
        prev[s] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j : graph[i].keySet()) {
                if (!visit[j] && distances[j] > distances[i] + 1) {
                    distances[j] = distances[i] + 1;
                    prev[j] = i;
                }
            }
        }
    }
//    public static void miniDijkstra(int p) {
//        for (int j : graph[])
//
//    }
    private static class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;this.v = v;
        }
    }
}
