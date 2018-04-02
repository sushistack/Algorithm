import java.io.*;
import java.util.ArrayList;

public class CFR470A {
    static int r, c, dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};
    static char map[][] = new char[501][501];
    static String ins[], in;
    static ArrayList<Point> wolves = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        r = Integer.parseInt(ins[0]);
        c = Integer.parseInt(ins[1]);
        wolves.clear();
        for (int i = 0; i < r; i++) {
            in = br.readLine();
            for (int j = 0; j < in.length(); j++) {
                map[i][j] = in.charAt(j);
                if (map[i][j] == 'W') wolves.add(new Point(i, j));
            }
        }
        boolean flag = true;
        for (int i = 0; i < wolves.size() && flag; i++) {
            flag = barrier(wolves.get(i));
        }
        StringBuilder sb = new StringBuilder();
        sb.append((flag) ? "Yes\n" : "No\n");
        if (flag) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static boolean barrier(Point p) {
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i], ny = p.y + dy[i];
            if (nx < 0 || nx > r - 1 || ny < 0 || ny > c - 1) continue;
            if (map[nx][ny] == 'S') return false;
            else if (map[nx][ny] == '.') map[nx][ny] = 'D';
        }
        return true;
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
