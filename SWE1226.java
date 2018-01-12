import java.io.*;
import java.util.Stack;

public class SWE1226 {
    static int t = 10, n;
    static int[][] map = new int[16][16];
    static String in;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Point s, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < 16; i++) {
                in = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = in.charAt(j) - 48;
                    if (map[i][j] == 2) s = new Point(i, j);
                    if (map[i][j] == 3) e = new Point(i, j);
                }
            }
            bw.write("#" + (10 - t) + " " + (dfs(s) ? "1" : "0") + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static boolean dfs(Point start) {
        Stack<Point> s = new Stack<>();
        boolean isArrive = false;
        boolean[][] v = new boolean[16][16];
        s.push(start);v[start.x][start.y] = true;
        while (!s.isEmpty()) {
            Point cur = s.pop();
            if (cur.x == e.x && cur.y == e.y) {isArrive = true; break;}
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 1 || nx > 14 || ny < 1 || ny > 14) continue;
                if (!v[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == 3)) {
                    s.push(new Point(nx, ny));v[nx][ny] = true;
                }
            }
        }
        return isArrive;
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
