import java.io.*;

public class B1074 {
    static Point dest;
    static int dx[] = {0, 0, 1, 1}, dy[] = {0, 1, 0, 1};
    static int n, r, c, ans = 0;
    static boolean flag = true;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        r = Integer.parseInt(ins[1]);
        c = Integer.parseInt(ins[2]);
        dest = new Point(r, c);
        ans = dac(new Point(0, 0), 1 << n);
        bw.write( ans + "\n");
        bw.flush();bw.close();

    }

    public static int dac(Point s, int l) {
        if (l == 1) return 1;
        int a = 0;
        for (int i = 0; i < 4; i++) {
            int nx = s.x + ((dx[i] == 0) ? 0 : (l >> dx[i]));
            int ny = s.y + ((dy[i] == 0) ? 0 : (l >> dy[i]));
            if (!((nx <= dest.x && nx + (l >> 1) > dest.x) && ny <= dest.y && ny + (l >> 1) > dest.y)) {
                if (flag) a += ((l >> 1) * (l >> 1));continue;
            }
            if (l == 2 && dest.x == nx && dest.y == ny) flag = false;
            if (flag) a += dac(new Point(nx, ny), l >> 1);
        }
        return a;
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
