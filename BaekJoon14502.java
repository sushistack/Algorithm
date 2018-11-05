import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon14502 {
    static int n, m, map[][], v, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, ans;
    static List<Point> viruses = new ArrayList<>();
    static List<Point> empties = new ArrayList<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        StringTokenizer st;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            v = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                map[i][v] = Integer.parseInt(st.nextToken());
                if (map[i][v] == 2) viruses.add(new Point(i, v));
                else if (map[i][v] == 0) empties.add(new Point(i, v));
                v++;
            }
        }
        dfs(0, 0, new ArrayList<>());
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }


    private static void dfs (int i, int cnt, List<Point> seleted) {
        if (cnt == 3) {
            int tmap[][] = new int[n][m];
            for (int j = 0; j < n; j++) {
                System.arraycopy(map[j], 0, tmap[j], 0, m);
            }
            for (int j = 0; j < seleted.size(); j++) {
                Point p = seleted.get(j);
                tmap[p.x][p.y] = 1;
            }
            for (Point v : viruses) {
                spread(tmap, v);
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    count += (tmap[j][k] == 0) ? 1 : 0;
                }
            }
            ans = Math.max(ans, count);
            return;
        }
        if (i == empties.size()) return;
        dfs(i + 1, cnt, seleted);
        seleted.add(empties.get(i));
        dfs(i + 1,cnt + 1, seleted);
        seleted.remove(seleted.size() - 1);
    }

    private static void spread(int[][] map, Point v) {
        Stack<Point> s = new Stack<>();
        boolean vistit[][] = new boolean[n][m];
        s.push(v);
        vistit[v.x][v.y]= true;
        while (!s.isEmpty()) {
           Point cur = s.pop();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
                if (map[nx][ny] == 0 && !vistit[nx][ny]) {
                    s.push(new Point(nx, ny));
                    map[nx][ny] = 2;
                    vistit[nx][ny] = true;
                }
            }
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
