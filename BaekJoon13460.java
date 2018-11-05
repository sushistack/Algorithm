import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaekJoon13460 {
    static int n, m, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, answer = Integer.MAX_VALUE, callCnt = 0;
    static String ins[];
    static Point R, B, G;
    static char[][] map = new char[11][];
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') R = new Point(i, j);
                if (map[i][j] == 'B') B = new Point(i, j);
                if (map[i][j] == 'O') G = new Point(i, j);
            }
        }
        dfs(-1, 0, new ArrayList<>());
        bw.write(answer == Integer.MAX_VALUE ? "-1\n" : answer + "\n");
        bw.flush();bw.close();
    }

    private static void dfs(int prev, int cnt, List<Integer> dirs) throws CloneNotSupportedException {
        if (cnt == 10) {
            answer = Math.min(process(dirs), answer);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (i == prev) continue;
            dirs.add(i);
            dfs(i,cnt + 1, dirs);
            dirs.remove(dirs.size() - 1);
        }
    }

    private static int process(List<Integer> dir) throws CloneNotSupportedException {
        Point r, b, g;
        r = (Point)R.clone();
        b = (Point)B.clone();
        g = (Point)G.clone();
        char tmap[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0,tmap[i], 0, m);
        }
        int ans = 0;
        List<Integer> dirs = new ArrayList<>();
        dirs.addAll(dir);

        while (!dirs.isEmpty()) {
            int d = dirs.remove(0);
            if (isRedFirst(d, r, b)) {
                moveBead(r, d, 'R', tmap);
                moveBead(b, d, 'B', tmap);
            } else {
                moveBead(b, d, 'B', tmap);
                moveBead(r, d, 'R', tmap);
            }
            ans++;
            if (b.isFall) return Integer.MAX_VALUE;
            if (r.equals(g) && !b.equals(g)) {
                return ans;
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean isRedFirst(int d, Point r, Point b) {
        switch (d) {
            case 0 : return r.x < b.x;
            case 1 : return r.x > b.x;
            case 2 : return r.y < b.y;
            case 3 : return r.y > b.y;
            default: throw new IllegalArgumentException();
        }
    }

    private static void moveBead(Point p, int d, char c, char[][] map) {
        int rx = p.x + dx[d], ry = p.y + dy[d];
        while (map[rx][ry] == '.') {
            rx += dx[d];
            ry += dy[d];
        }
        if (map[rx][ry] == '#' || map[rx][ry] == 'R' || map[rx][ry] == 'B') {
            rx -= dx[d];
            ry -= dy[d];
        }
        if (map[rx][ry] != 'O') map[rx][ry] = c;
        if (!(rx == p.x && ry == p.y)) map[p.x][p.y] = '.';
        p.x = rx;
        p.y = ry;
        if (p.equals(G)) p.isFall = true;
    }

    private static class Point implements Cloneable {
        int x, y;
        boolean isFall = false;
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public Point(int x, int y) {
            this.x = x;this.y = y;
        }

        public boolean equals(Point o) {
            return (this.x == o.x && this.y == o.y);
        }
    }

}
