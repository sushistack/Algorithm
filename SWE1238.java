import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SWE1238 {
    static int t = 10, l, s, u, v;
    static String ins[];
    static ArrayList<Node>[] g = new ArrayList[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 101; i++) g[i] = new ArrayList<>();
        while (t-- != 0) {
            ins = br.readLine().split(" ");
            l = Integer.parseInt(ins[0]);
            s = Integer.parseInt(ins[1]);
            ins = br.readLine().split(" ");
            for (int i = 0; i < 101; i++) g[i].clear();
            for (int i = 0; i < l; i+=2) {
                u = Integer.parseInt(ins[i]);
                v = Integer.parseInt(ins[i + 1]);
                g[u].add(new Node(v, 0));
            }

            sb.append("#");sb.append(10 - t);sb.append(" ");
            sb.append(bfs(new Node(s, 0)));sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }



    public static int bfs(Node s) {
        boolean[] visited = new boolean[101];
        Queue<Node> q = new LinkedList<>();
        q.offer(s);visited[s.v] = true;
        int max = -1, count = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (count == cur.c) {
                max = Math.max(max, cur.v);
            }
            if (count < cur.c) {
                count = cur.c;
                max = cur.v;
            }
            for (int i = 0; i < g[cur.v].size(); i++) {
                int next = g[cur.v].get(i).v;
                int c = cur.c;
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, c + 1));
                }
            }
        }
        return max;
    }

    private static class Node {
        int v, c;
        Node(int v, int c) {
            this.v = v;this.c = c;
        }
    }
}
