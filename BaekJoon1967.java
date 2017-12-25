import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1967 {
    static int n, u, v, w, max, maxIndex;
    static boolean[] visit = new boolean[100001];
    static HashMap<Integer, Integer>[] hm = new HashMap[100001];
    static int[] list = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            hm[i] = new HashMap<>();
        }
        for (int i = 1; i <= n - 1; i++) {
            u = sc.nextInt();v = sc.nextInt();w = sc.nextInt();
            hm[u].put(v, w);hm[v].put(u, w);
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
    private static class Edge{
        int v, w;
        Edge(int v, int w) {
            this.v = v; this.w = w;
        }
    }
}
