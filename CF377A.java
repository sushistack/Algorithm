import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class CF377A {
    static int n, m , k, c = 0;
    static Point t;
    static String ins[], in;
    static char[][] map = new char[505][505];
    static boolean[][] visited = new boolean[505][505];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        k = Integer.parseInt(ins[2]);
        Arrays.fill(map[0], '#');
        Arrays.fill(map[n + 1], '#');
        for (int i = 1; i <= n; i++) {
            in = br.readLine();
            map[i][0] = '#';map[i][m + 1] = '#';
            for (int j = 1; j <= m; j++) {
                map[i][j] = in.charAt(j - 1);
                if (map[i][j] == '.') {
                    if (t == null) t = new Point(i, j);
                    c++;
                }

            }
        }
        c -= k;
        dfs(t);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == '$') sb.append('.');
                else if (map[i][j] == '.') sb.append('X');
                else sb.append(map[i][j]);

            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();

    }
    
    public static void dfs(Point p) {
        Stack<Point> s = new Stack<>();
        s.push(p);
        while (!s.isEmpty()) {
            Point cur = s.pop();
            c--; map[cur.x][cur.y] = '$';
            if (c == 0) break;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (!visited[nx][ny] && map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    s.push(new Point(nx, ny));
                }
            }
        }
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
