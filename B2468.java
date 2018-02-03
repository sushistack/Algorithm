import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class B2468 {
    static int n, map[][] = new int[101][101], dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0}, max = 0;
    static String ins[];
    static boolean[][] visited = new boolean[101][101];;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(ins[j]);
                max = Math.max(max, map[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < max; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) Arrays.fill(visited[j], false);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visited[j][k] || map[j][k] <= i) continue;
                    dfs(new Point(j, k), i);
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();

    }

    public static void dfs(Point p, int h) {
        Stack<Point> s = new Stack<>();
        s.push(p);visited[p.x][p.y] = true;
        while (!s.isEmpty()) {
            Point cur = s.pop();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) continue;
                if (!visited[nx][ny] && map[nx][ny] > h) {
                    s.push(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static class Point {
        int x, y;
        Point (int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
