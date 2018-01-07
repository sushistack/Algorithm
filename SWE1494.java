import java.io.*;

public class SWE1494 {
    static int t, T, n, x, y, m;
    static Point[] ps = new Point[21];
    static String[] ins;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            ans = Long.MAX_VALUE;
            long ax = 0, ay = 0;
            for (int i = 1; i <= n; i++) {
                ins = br.readLine().split(" ");
                x = Integer.parseInt(ins[0]);
                y = Integer.parseInt(ins[1]);
                ps[i] = new Point(x, y);
            }
            dfs(0, ax, ay, n >> 1);
            bw.write("#" + (t - T) + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static void dfs(int plus,long ax, long ay, int c) {
        if (c == 0) {
            for (int i = plus + 1; i <= n; i++) {
                ax -= ps[i].x;ay -= ps[i].y;
            }
            ans = Math.min(ans, (ax * ax) + (ay * ay));
        }else {
            for (int i = plus + 1; i <= n; i++) {
                ax += ps[i].x;ay += ps[i].y;
                dfs(i, ax, ay, c - 1);
                ax -= ps[i].x; ax -= ps[i].x;
                ay -= ps[i].y; ay -= ps[i].y;
            }
        }
    }


    private static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
