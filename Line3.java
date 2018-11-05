import java.io.*;
import java.util.*;

public class Line3 {
    static int n, x, y, count = 0, group = 0;
    static boolean[] visited = new boolean[100001];
    static String ins[];
    static ArrayList<Integer>[] g = new ArrayList[100001];
    static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < 100001; i++) g[i] = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            x = Integer.parseInt(ins[0]);
            y = Integer.parseInt(ins[1]);
            g[x].add(y);g[y].add(x);
            if (!hs.contains(x)) hs.add(x);
            if (!hs.contains(y)) hs.add(y);
        }
        Iterator<Integer> it = hs.iterator();
        while (it.hasNext()) {
            int p = it.next();
            if (!visited[p]) {
                bfs(p);
                group++;
            }
        }
        bw.write(group + "\n");
        bw.flush();bw.close();
    }


    public static void bfs(int c) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g[cur].size(); i++) {
                int to = g[cur].get(i);
                if (!visited[to]) {
                    visited[to] = true;
                    q.offer(to);
                    count++;
                }
            }
        }
    }

}
