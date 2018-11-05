import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SWE2115 {
    static int t, T, n, m, c, map[][] = new int[10][10], p1, p2;
    static int dp[][][] = new int[11][11][11];
    static String ins[];
    static PriorityQueue<Pos> pq = new PriorityQueue<>();
    static HashSet<String> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            m = Integer.parseInt(ins[1]);
            c = Integer.parseInt(ins[2]);
            for (int i = 0; i < 11; i++)
                for (int j = 0; j < 11; j++)
                    Arrays.fill(dp[i][j], -1);
            pq.clear();hs.clear();
            for (int i = 0; i < n; i++) {
                ins = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(ins[j]);
                }
            }
            sb.append("#");sb.append(t - T);
            sb.append(" ");sb.append(getMaxRevenue());
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static int getMaxRevenue() {
        int max = -1, ans;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - m + 1; j++) {
                dp(0, i, j, j + m - 1, 0, 0);
            }
        }
        Pos maxPos = pq.poll();
        ans = maxPos.v;
        while (!pq.isEmpty()) {
            Pos p = pq.poll();
            if (maxPos.r != p.r) {
                ans += p.v;break;
            }else if (p.x > maxPos.y || p.y < maxPos.x) {
                ans += p.v;break;
            }
        }
        return ans;
    }

    private static void dp(int idx,  int r, int x, int y, int bsum, int sqsum) {
        if (idx == m) {
            dp[r][x][y] = Math.max(dp[r][x][y], sqsum);
            if (hs.contains(dp[r][x][y] + " " + r + " " + x + " " + y)) return;
            pq.offer(new Pos(dp[r][x][y], r, x, y));
            hs.add(dp[r][x][y] + " " + r + " " + x + " " + y);
            return;
        }
        dp(idx + 1, r, x, y, bsum, sqsum);
        bsum += map[r][idx + x];
        sqsum += Math.pow(map[r][idx + x], 2);
        if (bsum <= c) dp(idx + 1, r, x, y, bsum, sqsum);

    }

    private static class Pos implements Comparable<Pos> {
        int v, r, x, y;
        @Override
        public int compareTo(Pos o) {
            return -1 * Integer.compare(this.v, o.v);
        }
        Pos(int v, int r, int x, int y) {
            this.v = v;this.r = r;this.x = x;this.y = y;
        }
    }
}
