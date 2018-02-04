import java.io.*;

public class B1987 {
    static int r, c, dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0}, max = 0;
    static String ins[];
    static char[][] map = new char[21][21];
    static boolean[] a = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        r = Integer.parseInt(ins[0]);
        c = Integer.parseInt(ins[1]);
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        a[map[0][0] - 65] = true;
        dfs(new Point(0, 0), new Point(-1, 0), a, 1);
        bw.write(max + "\n");
        bw.flush();bw.close();

    }

    public static void dfs(Point p, Point prev, boolean[] alph, int count) {
        max = Math.max(max, count);
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i], ny = p.y + dy[i];
            if(nx < 0 || nx > r - 1 || ny < 0 || ny > c - 1) continue;
            if (nx == prev.x && ny == prev.y) continue;
            if (alph[map[nx][ny] - 65]) continue;
            boolean[] na = new boolean[26];
            System.arraycopy(alph, 0, na, 0, 26);
            na[map[nx][ny] - 65] = true;
            dfs(new Point(nx, ny), new Point(p.x, p. y), na, count + 1);
        }

    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
