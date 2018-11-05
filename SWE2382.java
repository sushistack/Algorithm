import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SWE2382 {
    static int t, T, n, m, k, v, ans;
    static int dx[] = {0, -1, 1, 0, 0}, dy[] = {0, 0, 0, -1, 1};
    static Cluster[] cs;
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
            k = Integer.parseInt(ins[2]);
            int x, y, c, d;
            cs = new Cluster[k];
            for (int i = 0; i < k; i++) {
                ins = br.readLine().split(" ");
                x = Integer.parseInt(ins[0]);
                y = Integer.parseInt(ins[1]);
                c = Integer.parseInt(ins[2]);
                d = Integer.parseInt(ins[3]);
                cs[i] = new Cluster(x, y, c, d);
            }

            for (int i = 1; i <= m; i++) {
                move();
            }
            ans = 0;
            for (int i = 0; i < k; i++) {
                ans += cs[i].mic;
            }
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void move() {
        HashMap<Point, ArrayList<Cluster>> moved = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i].mic == 0) continue;
            int nx = cs[i].x + dx[cs[i].d], ny = cs[i].y += dy[cs[i].d];
            if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) continue;
            cs[i].x = nx;cs[i].y = ny;
            if (nx == 0 || ny == 0 || ny == n - 1 || nx == n - 1) {
                switch (cs[i].d) {
                    case 1: cs[i].d = 2; break;
                    case 2: cs[i].d = 1; break;
                    case 3: cs[i].d = 4; break;
                    case 4: cs[i].d = 3; break;
                }
                cs[i].mic /= 2;
            }
            Point p = new Point(nx, ny);
            ArrayList<Cluster> c = ((moved.containsKey(p))) ? moved.get(p) : new ArrayList<>();
            c.add(cs[i]);
            moved.put(p, c);
        }
        ArrayList<Cluster> c;
        for (Point key : moved.keySet()) {
            c = moved.get(key);
            if (c.size() < 2) continue;
            int maxIdx = -1, max = 0;
            for (int i = 0; i < c.size(); i++) {
                if (max < c.get(i).mic) {
                    max = c.get(i).mic;
                    maxIdx = i;
                }
            }
            Cluster maxCluster = c.get(maxIdx);
            for (int i = 0; i < c.size(); i++) {
                if (i == maxIdx) continue;
                maxCluster.mic += c.get(i).mic;
                c.get(i).mic = 0;
            }
        }
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static class Cluster {
        int  x, y, mic, d;
        Cluster(int x, int y, int mic, int d) {
            this.x = x;this.y = y;this.mic = mic;this.d = d;
        }
    }
}
