import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class SWE2105 {
    static int t, T, n;
    static int[][] map = new int[21][21];
    static String ins[];
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    final static int RD = 0, LD = 1, LU = 2, RU = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                ins = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(ins[j - 1]);
                }
            }
            int max = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j + 1 > n || j - 1 < 1 || i + 2 > n) continue;
                    boolean[] dessert = new boolean[101];
                    max = Math.max(max, bfs(new Point(i, j, RD, 0, dessert)));
                }
            }

            bw.write("#" + (t - T) + " " + ((max == 0) ? -1 : max)  + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static int bfs(Point s) {
        Queue<Point> q = new LinkedList<>();
        s.dessert[map[s.x + dx[RD]][s.y + dy[RD]]] = true;
        q.offer(new Point(s.x + dx[RD], s.y + dy[RD], RD, 1, s.dessert));
        int max = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == s.x && cur.y == s.y) {
                max = Math.max(max, cur.c);
                continue;
            }
            int nx, ny;
            if (cur.d != RU) {
                for (int i = cur.d; i <= cur.d + 1; i++) {
                    nx = cur.x + dx[i]; ny = cur.y + dy[i];
                    if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
                    if (!cur.dessert[map[nx][ny]]) {
                        cur.dessert[map[nx][ny]] = true;
                        q.offer(new Point(nx, ny, i, cur.c + 1, cur.dessert));
                        cur.dessert[map[nx][ny]] = false;
                    }
                }
            }else {
                nx = cur.x + dx[RU]; ny = cur.y + dy[RU];
                if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if (!cur.dessert[map[nx][ny]]) {
                    cur.dessert[map[nx][ny]] = true;
                    q.offer(new Point(nx, ny, RU, cur.c + 1, cur.dessert));
                    cur.dessert[map[nx][ny]] = false;
                }
            }
        }
        return max;
    }

    private static class Point {
        int x, y, d, c;
        boolean[] dessert = new boolean[101];
        Point(int x, int y, int d, int c, boolean[] dessert) {
            this.x = x;this.y = y;this.d = d; this.c = c;
            System.arraycopy(dessert, 0, this.dessert, 0, 101);
        }
    }
}
