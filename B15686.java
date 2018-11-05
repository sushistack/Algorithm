import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15686 {
    static int n, m, v, map[][], ans;
    static List<Point> homes = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            v = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                map[i][v] = Integer.parseInt(st.nextToken());
                if (map[i][v] == 1) homes.add(new Point(i, v));
                if (map[i][v] == 2) chickens.add(new Point(i, v));
                v++;
            }
        }
        ans = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    private static void dfs(int i, int status, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (Point h : homes) {
                h.d = Integer.MAX_VALUE;
                for (int k = 0; k < chickens.size(); k++) {
                    if ((status & (1 << k)) != 0) {
                        Point p = chickens.get(k);
                        int d = getDist(h, p);
                        h.d = (h.d > d) ? d : h.d;
                    }
                }
                sum += h.d;
            }
            ans = Math.min(ans, sum);
            return;
        }
        if (i == chickens.size()) return;
        dfs(i + 1, status, cnt);
        dfs(i + 1, status | (1 << i), cnt + 1);
    }

    private static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private static class Point {
        int x, y, d;

        public Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
