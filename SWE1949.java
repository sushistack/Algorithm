import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class SWE1949 {
    static int t, T, n, k, max, ans;
    static int[][] map = new int[8][8];
    static String ins[];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            k = Integer.parseInt(ins[1]);
            max = 0;
            for (int i = 0; i < n; i++) {
                ins = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(ins[j]);
                    max = Math.max(max, map[i][j]);
                }
            }
            ArrayList<Point> mp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (max == map[i][j]) mp.add(new Point(i, j, 1, true));
                }
            }
            ans = 0;
            for (int i = 0; i < mp.size(); i++) {
                dfs(mp.get(i), -1, -1, map);
            }
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static void dfs(Point p, int x, int y, int[][] map) {
        ans = Math.max(ans, p.c);
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i], ny = p.y + dy[i];
            if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) continue;
            if ((nx == x && ny == y)) continue;
            if (map[p.x][p.y] > map[nx][ny]) {
                dfs(new Point(nx, ny, p.c + 1, p.isMagic), p.x, p.y, map);
            }else {
                if (p.isMagic && map[nx][ny] - map[p.x][p.y] < k) {
                    int temp = map[nx][ny];
                    map[nx][ny] = map[p.x][p.y] - 1;
                    dfs(new Point(nx, ny, p.c + 1, false), p.x, p.y, map);
                    map[nx][ny] = temp;
                }
            }
        }
    }

    private static class Point {
        int x, y, c;
        boolean isMagic;
        Point (int x, int y, int c, boolean m) {
            this.x = x; this.y = y;this.c = c; this.isMagic = m;
        }
    }
}
