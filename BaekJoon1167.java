import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1167 {
    static int V, u, v, w, max, maxIndex;
    static boolean[] visit = new boolean[100001];
    static HashMap<Integer, Integer>[] hm = new HashMap[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        for (int i = 1; i <= V; i++) {
            hm[i] = new HashMap<>();
        }

        for (int i = 1; i <= V; i++) {
            u = sc.nextInt();
            while (true) {
                v = sc.nextInt();
                if (v == -1) break;
                w = sc.nextInt();
                hm[u].put(v, w);
            }
        }
        dfs(1);dfs(maxIndex);
        System.out.println(max);
    }
    public static int dfs(int v)  {
        Arrays.fill(visit, false);
        Stack<Edge> s = new Stack<>();
        max = 0;maxIndex = 1;s.push(new Edge(v, 0));
        visit[v] = true;
        while (!s.isEmpty()) {
            Edge curNode = s.pop();
            if (max < curNode.w) {
                max = curNode.w; maxIndex = curNode.v;
            }
            for (int key : hm[curNode.v].keySet()) {
                Edge e = new Edge(key, hm[curNode.v].get(key));
                if (!visit[e.v]) {
                    visit[e.v] = true; s.push(new Edge(e.v, e.w + curNode.w));
                }
            }
        }
        return max;
    }
    private static class Edge {
        int v, w;
        Edge(int v, int w) {
            this.v = v; this.w = w;
        }
    }
}
