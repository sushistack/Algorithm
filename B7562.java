import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class B7562 {
    static int T, l, dx[] = {-1, -2, -1, -2, 1, 2, 1, 2};
    static int dy[] = {-2, -1, 2, 1, -2, -1, 2, 1};
    static Point s, e;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            l = Integer.parseInt(br.readLine());
            ins = br.readLine().split(" ");
            s = new Point(Integer.parseInt(ins[0]), Integer.parseInt(ins[1]), 0);
            ins = br.readLine().split(" ");
            e = new Point(Integer.parseInt(ins[0]), Integer.parseInt(ins[1]), 0);
            bw.write(bfs(s) + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static int bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        boolean visited[][] = new boolean[301][301];
        q.offer(p); visited[p.x][p.y] = true;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == e.x && cur.y == e.y) min = Math.min(min, cur.c);
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 0 || nx > l - 1 || ny < 0 || ny > l - 1) continue;
                if (!visited[nx][ny]) {
                    q.offer(new Point(nx, ny, cur.c + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return min;
    }


    private static class Point {
        int x, y, c;
        Point(int x, int y, int c) {
            this.x = x;this.y = y;this.c = c;
        }
    }
}
