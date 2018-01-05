import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SWE2819 {
    static int t, T;
    static int[][] map = new int[4][4];
    static String[] ins;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        T = t;
        while (T-- != 0) {
            for (int i = 0; i < 4; i++) {
                Arrays.fill(map[i], 0);
            }
            hm.clear();
            for (int i = 0; i < 4; i++) {
                ins = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(ins[j]);
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    bfs(new Point(i, j, 0, ""));
                }
            }
            bw.write("#" + (t - T) + " " + hm.size() + "\n");
            bw.flush();
        }
        bw.close();
    }
    public static void bfs(Point s) {
        Queue<Point> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.c == 7 && !hm.containsKey(cur.s)) hm.put(cur.s, 1);
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > 3 || ny < 0 || ny > 3) continue;
                if (cur.c < 7) q.offer(new Point(nx, ny, cur.c + 1, cur.s + map[nx][ny]));
            }
        }
    }

    private static class Point {
        int x, y, c;
        String s;
        Point(int x, int y,int c, String s) {
            this.x = x;this.y = y;this.c = c;this.s = s;
        }
    }
}
