import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B15684 {
    static int n, m, h, map[][] = new int[31][20], r, c, ans;
    static List<Point> horiz = new ArrayList<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        h = Integer.parseInt(ins[2]);
        Arrays.fill(map[h], 1);

        for (int i = 0; i < h; i ++) {
            for (int j = 0; j < (n << 1) - 1; j += 2) {
                map[i][j] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            r = Integer.parseInt(ins[0]) - 1;
            c =  2 * Integer.parseInt(ins[1]) - 1;
            map[r][c] = 1;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 1; j < (n << 1) - 1; j += 2) {
                if (map[i][j] == 1) continue;
                boolean prev = (j - 2 >= 0 && map[i][j - 2] == 1);
                boolean next = (j + 2 <= (n << 1) - 1 && map[i][j + 2] == 1);
                if (!prev && !next) horiz.add(new Point(i, j));
            }
        }

        ans = -1;
        for (int i = 0; i < 4; i++) {
            if (dfs(0, 0, i, map)) {
                ans = i;
                break;
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }


    private static boolean dfs(int i, int c, int cnt, int[][] map) {
        if (c == cnt) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (j != downLadder(j, map)) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        if (i == horiz.size()) return false;
        if (dfs(i + 1, c, cnt, map)) return true;

        int x = horiz.get(i).x, y = horiz.get(i).y;

        boolean prev = (y - 2 >= 0 && map[x][y - 2] == 1);
        boolean next = (y + 2 <= (n << 1) - 1 && map[x][y + 2] == 1);
        if (prev || next) return false;
        map[x][y] = 1;
        if (dfs(i + 1, c + 1, cnt, map)) return true;
        map[x][y] = 0;
        return false;
    }

    private static void print() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < (n << 1) - 1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int downLadder(int idx, int map[][]) {
        Point p = new Point(0, 2 * idx);
        int dx[] = {0, 0, 1}, dy[] = {-1, 1, 0};

        while (true) {
            for (int i = 0; i < 3; i++) {
                int nx = p.x + dx[i], ny = p.y + dy[i];
                if (nx < 0 || nx > h || ny < 0 || ny > (n << 1) - 1) continue;
                if (map[nx][ny] == 0) continue;
                if (i < 2) {
                    nx += dx[i] + 1;
                    ny += dy[i];
                }
                p.x = nx; p.y = ny;
                break;
            }
            if (p.x == h) break;
        }
        return p.y >> 1;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
