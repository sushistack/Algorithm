import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWE1861 {
    static int t, T, n, sx, sy;
    static int[][] map = new int[1001][1001];
    static String[] ins;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited = new boolean[1001][1001];
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
            for (int i = 1; i <= n; i++) {
                Arrays.fill(visited[i], false);
            }
            int max = 0, maxX = 0, maxY = 0;
            map[0][0] = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[i][j]) continue;
                    int t = bfs(new Point(i, j, 1));
                    Point t2 = bfs2(new Point(i ,j, 0));
                    if (max < (t + t2.c)) {
                        max = (t + t2.c);maxX = t2.x;maxY = t2.y;
                    }else if (max == (t + t2.c) && map[maxX][maxY] > map[t2.x][t2.y]) {
                        maxX = t2.x;maxY = t2.y;
                    }
                }
            }

            bw.write("#" + (t - T) + " " + map[maxX][maxY] + " " + max + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static int bfs(Point s) {
        Queue<Point> q = new LinkedList<>();
        q.offer(s);visited[s.x][s.y] = true;
        int lMax = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if (!visited[nx][ny] && map[nx][ny] - map[cur.x][cur.y] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, cur.c + 1));
                    lMax = Math.max(lMax, cur.c + 1);
                }
            }
        }
        return lMax;
    }

    public static Point bfs2(Point s) {
        Queue<Point> q = new LinkedList<>();
        q.offer(s);
        Point p = new Point();
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if (!visited[nx][ny] && map[nx][ny] - map[cur.x][cur.y] == -1) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, cur.c + 1));
                }
            }
            if (q.isEmpty()) p = cur;
        }
        return p;
    }

    private static class Point {
        int x, y, c;
        Point() {x = 0; y = 0; c= 0; }
        Point(int x, int y, int c) {
            this.x = x;this.y = y;this.c = c;
        }
    }

}
