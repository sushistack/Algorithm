import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWE1953 {
    static int t, T, n, m, r, c, l, map[][], v, ans;
    static int pipes[] = {4, 2, 2, 2, 2, 2, 2};
    static int dx[][] = { {1, -1, 0, 0}, {-1, 1}, {0, 0}, {-1, 0}, {1, 0}, {1, 0}, {-1, 0} };
    static int dy[][] = { {0, 0, 1, -1}, {0, 0}, {-1, 1}, {0, 1}, {0, 1}, {0, -1}, {0, -1} };
    static boolean visited[][] = new boolean[51][51];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            m = Integer.parseInt(ins[1]);
            r = Integer.parseInt(ins[2]);
            c = Integer.parseInt(ins[3]);
            l = Integer.parseInt(ins[4]);
            StringTokenizer st;
            Point s = new Point(r, c, 0);
            map = new int[51][51];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                v = 0;
                while (st.hasMoreTokens()) {
                    map[i][v++] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 51; i++) {
                Arrays.fill(visited[i], false);
            }
            ans = 1;
            bfs(s);
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void bfs(Point s) {
        Queue<Point> q = new LinkedList<>();
        q.offer(s);visited[s.x][s.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int t = map[cur.x][cur.y] - 1;
            if (cur.c == l - 1) continue;
            for (int i = 0; i < pipes[t]; i++) {
                int nx = cur.x + dx[t][i], ny = cur.y + dy[t][i];
                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) continue;
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;
                if (!isPath(cur.x, cur.y, nx, ny)) continue;
                visited[nx][ny] = true;
                ans++;
                q.offer(new Point(nx, ny, cur.c + 1));
            }
        }
    }

    private static boolean isPath(int x1, int y1, int x2, int y2) {
        int next = map[x2][y2];
        if (x1 > x2) {// 이전이 아래인 경우
            if (next == 3 || next == 4 || next == 7) return false;
        }else if (x1 == x2) {
            if (y1 > y2) {  // 이전이 오른쪽인 경우
                if (next == 2 || next == 6 || next == 7) return false;
            } else {//이전이 왼쪽인 경우
                if (next == 2 || next == 4 || next == 5) return false;
            }
        } else {// 이전이 위인 경우
            if (next == 3 || next == 5 || next == 6) return false;
        }
        return true;
    }

    private static class Point {
        int x, y, c;
        Point(int x, int y, int c) {
            this.x = x;this.y = y;this.c = c;
        }
    }

}
