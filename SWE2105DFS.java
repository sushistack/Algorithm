import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE2105DFS {
    static int t, T, n, map[][] = new int[21][21], max;
    static int dx[] = {1, 1, -1, -1}, dy[] = {1, -1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                int v = 1;
                st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    map[i][v++] = Integer.parseInt(st.nextToken());
                }
            }
            max = -1;
            boolean[] b = new boolean[101];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j + 1 > n || j - 1 < 1 || i + 2 > n) continue;
                    Arrays.fill(b, false);
                    Point s = new Point(i, j);
                    dfs(s, s, b, 0);
                }
            }
            sb.append("#");sb.append(t - T);
            sb.append(" ");sb.append(max);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();

    }

    private static void dfs(Point s, Point cur, boolean[] type, int d) {
        if (cur.x == s.x && cur.y == s.y && !cur.equals(s)) {
            int cnt = 0;
            for (int i = 0; i < 101; i++) {
                cnt += type[i] ? 1 : 0;
            }
            max = Math.max(max, cnt);
        }
        int nx, ny;
        for (int i = 0; i < 2; i++) {
            if (d + i == 4) continue;
            nx = cur.x + dx[d + i];
            ny = cur.y + dy[d + i];
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            if (!type[map[nx][ny]]) {
                type[map[nx][ny]] = true;
                dfs(s, new Point(nx, ny), type, d + i);
                type[map[nx][ny]] = false;
            }
        }


    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
