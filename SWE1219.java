import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SWE1219 {
    static int t = 10, n, e;
    static ArrayList<Integer>[] g = new ArrayList[101];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 101; i++) {
            g[i] = new ArrayList<>();
        }
        while (t-- != 0) {
            for (int i = 0; i < 101; i++) {
                g[i].clear();
            }
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            e = Integer.parseInt(ins[1]);
            ins = br.readLine().split(" ");
            for (int i = 0; i < 2*e; i += 2) {
                g[Integer.parseInt(ins[i])].add(Integer.parseInt(ins[i + 1]));
            }
            bw.write("#" + (10 - t) + " " + ((bfs()) ? 1 : 0) + "\n");
            bw.flush();
        }
        bw.close();
    }
    public static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[101];
        q.offer(0);v[0] = true;
        boolean isArrive = false;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 99) {isArrive = true;break;}
            for (int i = 0; i < g[cur].size(); i++) {
                int to = g[cur].get(i);
                if (!v[to]) {
                    v[to] = true;q.offer(to);
                }
            }
        }
        return isArrive;
    }

}
