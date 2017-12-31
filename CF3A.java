import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class CF3A {
    static String in;
    static Point s, e;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        s = new Point(57 - in.charAt(1), in.charAt(0) - 96, 0, "");
        in = br.readLine();
        e = new Point(57 - in.charAt(1), in.charAt(0) - 96, 0,"");
        bw.write(bfs());
        bw.flush();bw.close();
    }

    public static String bfs() {
        Queue<Point> q = new LinkedList<>();
        String ans = "";
        int n = 0;
        boolean[][] v = new boolean[9][9];
        q.offer(s); v[s.x][s.y] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == e.x && cur.y == e.y) {
                ans = cur.path;n = cur.count;
            }
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > 8 || ny < 0 || ny > 8) continue;
                if (!v[nx][ny]) {
                    v[nx][ny] = true;
                    String dir = "";
                    switch (i) {
                        case 0: dir = "R\n"; break;
                        case 1: dir = "L\n"; break;
                        case 2: dir = "D\n"; break;
                        case 3: dir = "U\n"; break;
                        case 4: dir = "RU\n"; break;
                        case 5: dir = "LU\n"; break;
                        case 6: dir = "RD\n"; break;
                        case 7: dir = "LD\n"; break;
                    }
                    q.offer(new Point(nx, ny, cur.count+ 1, cur.path + dir));
                }
            }
        }
        return (n + "\n" + ans);
    }

    private static class Point {
        int x, y, count;
        String path;
        Point(int x, int y, int count, String path) {
            this.x = x; this.y = y;this.count = count;this.path = path;
        }
    }
}
