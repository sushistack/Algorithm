import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15683 {
    static int n, m, v, map[][], ans, types[] = {4, 2, 4, 4, 1};
    static List<Point> cctv = new ArrayList<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        map = new int[n][m];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            v = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                map[i][v] = Integer.parseInt(st.nextToken());
                if (map[i][v] > 0 && map[i][v] < 6) cctv.add(new Point(i, v, map[i][v] - 1));
                v++;
            }
        }
        ans = Integer.MAX_VALUE;
        dfs(0, cctv.size(), cctv);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }


    private static void dfs(int i, int cnt, List<Point> cctv) {
        if (i == cnt) {
            int mm[][] = new int[n][m];
            for (int j = 0; j < n; j++) {
                System.arraycopy(map[j], 0, mm[j], 0, m);
            }
            for (Point p : cctv) {
                p.spread(mm);
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    count += (mm[j][k] == 0) ? 1 : 0;
                }
            }
            ans = Math.min(ans, count);
            return;
        }

        for (int j = 0; j < types[cctv.get(i).d]; j++) {
            cctv.get(i).type = j;
            dfs(i + 1, cnt, cctv);
        }
    }

    private static class Point {
        int x, y, d, type;
        int dx[][] = {{1, -1, 0, 0},
                {1, 0},
                {-1, 0, 1, 0},
                {-1, 0, 1, 0},
                {-1, 0, 1, 0}};
        int dy[][] = {{0, 0, -1, 1},
                {0, 1},
                {0, 1, 0, -1},
                {0, 1, 0, -1},
                {0, 1, 0, -1}};


        public Point(int x, int y, int d) {
            this.x = x;this.y = y;this.d = d;
        }

        public void spread(int map[][]) {
            int tx = x, ty = y;
            switch (d) {
                case 0 :
                    while (true) {
                        int nx = x + dx[d][type], ny = y + dy[d][type];
                        if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) break;
                        if (map[nx][ny] == 6) break;
                        x = nx; y = ny;
                        if (map[nx][ny] != 0) continue;
                        map[nx][ny] = -1;
                    }
                    x = tx; y = ty;
                    break;
                case 1 : case 2 :
                    while (true) {
                        int nx = x + dx[d][type], ny = y + dy[d][type];
                        if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) break;
                        if (map[nx][ny] == 6) break;
                        x = nx; y = ny;
                        if (map[nx][ny] != 0) continue;
                        map[nx][ny] = -1;
                    }
                    x = tx; y = ty;
                    while (true) {
                        int nx = (d == 1) ? x - dx[d][type] : x + dx[d][(type + 1) % 4];
                        int ny = (d == 1) ? y - dy[d][type] : y + dy[d][(type + 1) % 4];
                        if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) break;
                        if (map[nx][ny] == 6) break;
                        x = nx; y = ny;
                        if (map[nx][ny] != 0) continue;
                        map[nx][ny] = -1;
                    }
                    x = tx; y = ty;
                    break;
                case 3 : case 4 :
                    for (int i = 0; i < 4; i++) {
                        if (d == 3 && type == i) continue;
                        while (true) {
                            int nx = x + dx[d][i], ny = y + dy[d][i];
                            if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) break;
                            if (map[nx][ny] == 6) break;
                            x = nx; y = ny;
                            if (map[nx][ny] != 0) continue;
                            map[nx][ny] = -1;
                        }
                        x = tx; y = ty;
                    }
                    x = tx; y = ty;
                    break;
            }
        }
    }
}
