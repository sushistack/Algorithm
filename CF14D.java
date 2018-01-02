import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class CF14D {
    static int n, u, v;
    static boolean[][] g = new boolean[201][201];
    static boolean[][] t1 = new boolean[201][201];
    static boolean[][] t2 = new boolean[201][201];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            ins = br.readLine().split(" ");
            u = Integer.parseInt(ins[0]);
            v = Integer.parseInt(ins[1]);
            g[u][v] = true; g[v][u] = true;
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j]) {
                    g[i][j] = false;g[j][i] = false;
                    int x1 = getDiameterOfTree(i);
                    int x2 = getDiameterOfTree(j);
                    max = Math.max(x1*x2, max);
                    g[i][j] = true;g[j][i] = true;
                }
            }
        }

        bw.write(max+ "\n");
        bw.flush();bw.close();

    }

    public static int getDiameterOfTree(int s) {
        int t = bfs(s, true);
        int d = bfs(t, false);
        return d;
    }

    public static int bfs(int s, boolean f) {
        Queue<Path> q = new LinkedList<>();
        boolean[] v = new boolean[201];
        q.offer(new Path(s, 0));v[s] = true;
        int max = -1, idx = -1;
        while (!q.isEmpty()) {
            Path cur = q.poll();
            if (max < cur.count) {
                idx = cur.cur;
                max = cur.count;
            }
            for (int i = 1; i <= n; i++) {
                if (!v[i] && g[cur.cur][i]) {
                    v[i] = true;
                    q.offer(new Path(i, cur.count + 1));
                }
            }
        }
        return (f) ? idx : max;
    }

    private static class Path {
        int cur, count;
        Path(int cur, int count) {
            this.cur = cur;this.count = count;
        }
    }
}
