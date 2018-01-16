import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SWE1248 {
    static int t, T, V, E, n1, n2, u, v;
    static String ins[];
    static Node[] g = new Node[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            V = Integer.parseInt(ins[0]);E = Integer.parseInt(ins[1]);
            n1 = Integer.parseInt(ins[2]);n2 = Integer.parseInt(ins[3]);
            ins = br.readLine().split(" ");
            for (int i = 1; i <= V; i++) g[i] = new Node();
            for (int i = 0; i < 2 * E; i += 2) {
                u = Integer.parseInt(ins[i]);
                v = Integer.parseInt(ins[i + 1]);
                if (g[u].lc == -1) g[u].lc = v;
                else g[u].rc = v;
                g[v].p = u;
            }
            ArrayList<Integer> path1 = bfs(n1);
            ArrayList<Integer> path2 = bfs(n2);
            int commonParent = -1;
            boolean isCommonParent = false;
            for (int i = 0; i < path1.size(); i++) {
                for (int j = 0; j < path2.size(); j++) {
                    if (path1.get(i).equals(path2.get(j))) {
                        isCommonParent = true;
                        commonParent = path1.get(i);
                        break;
                    }
                }
                if (isCommonParent) break;
            }
            bw.write("#" + (t - T) + " " + commonParent + " " + bfs2(commonParent) + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static ArrayList<Integer> bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(s);q.add(s);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (g[cur].p != -1) {
                q.offer(g[cur].p);
                l.add(g[cur].p);
            } else break;
        }
        return l;
    }

    public static int bfs2(int s) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(s);q.add(s);
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (g[cur].rc != -1) q.offer(g[cur].rc);
            if (g[cur].lc != -1) q.offer(g[cur].lc);
            count++;
        }
        return count;
    }

    private static class Node {
        int p, lc, rc;
        Node () { p = lc = rc = -1; }

    }

}
