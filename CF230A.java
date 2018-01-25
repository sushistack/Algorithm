import java.io.*;
import java.util.Arrays;

public class CF230A {
    static int n, s, x, y, idx = -1;
    static Point[] ps = new Point[1001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        s = Integer.parseInt(ins[0]);
        n = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            x = Integer.parseInt(ins[0]);
            y = Integer.parseInt(ins[1]);
            ps[i] = new Point(x, y);
        }
        Arrays.sort(ps, 0, n);
        for (int i = 0; i < n; i++) {
            if (s > ps[i].x) {s += ps[i].y;idx = i;}
            else break;
        }
        bw.write((idx == n - 1) ? "YES\n" : "NO\n");
        bw.flush();bw.close();

    }
    private static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x > o.x ? 1 : -1;
        }
    }
}
