import java.io.*;
import java.util.Arrays;

public class SWE1210 {
    final static int U = 0, R = 1, L =2;
    static int t = 10, ans;
    static int[][] map = new int[102][102];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Arrays.fill(map[0], -1);Arrays.fill(map[101], -1);
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            Point e = new Point();ans = -1;
            for (int j = 1; j <= 100; j++) {
                map[j][0] = map[j][101] = -1;
                ins = br.readLine().split(" ");
                for (int k = 1; k <= 100; k++) {
                    map[j][k] = Integer.parseInt(ins[k - 1]);
                    if (j == 100 && ins[k - 1].equals("2")) {
                        e = new Point(j, k);
                    }
                }
            }
            dfs(e, U);
            bw.write("#" + i + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static void dfs(Point p, int d) {
        if (p.x == 1) ans = p.y - 1;
        else {
            switch (d) {
                case U:
                    if (map[p.x][p.y - 1] == 1) dfs(new Point(p.x, p.y - 1), L);
                    else if (map[p.x][p.y + 1] == 1) dfs(new Point(p.x, p.y + 1), R);
                    else dfs(new Point(p.x - 1, p.y), U);break;
                case L:
                    if (map[p.x][p.y - 1] == 1) dfs(new Point(p.x, p.y - 1), L);
                    else dfs(new Point(p.x - 1, p.y), U);break;
                case R:
                    if (map[p.x][p.y + 1] == 1) dfs(new Point(p.x, p.y + 1), R);
                    else dfs(new Point(p.x - 1, p.y), U);break;
            }
        }
    }

    private static class Point {
        int x, y;
        Point() { x = 0; y = 0; }
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
