import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon14503 {
    static int n, m, r, c, d, map[][], dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        r = Integer.parseInt(ins[0]);
        c = Integer.parseInt(ins[1]);
        d = Integer.parseInt(ins[2]);
        Point cleaner = new Point(r, c, d);
        map = new int[n][m];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            int v = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                map[i][v++] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        while (true) {
            if (map[cleaner.x][cleaner.y] == 0) {
                ans++;
                map[cleaner.x][cleaner.y] = 2;
            }
            int i = 0;
            while (i++ < 4) {
                cleaner.rotate();
                int nx = cleaner.x + dx[cleaner.d], ny = cleaner.y + dy[cleaner.d];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
                if (map[nx][ny] == 0) {
                    cleaner.x = nx;
                    cleaner.y = ny;
                    break;
                }
            }
            if (i == 5) {
                int nx, ny;
                nx = cleaner.x + dx[(cleaner.d + 2) % 4];
                ny = cleaner.y + dy[(cleaner.d + 2) % 4];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) break;
                if (map[nx][ny] == 1) break;
                cleaner.moveBack();
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }


    private static class Point {
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;this.y = y;this.d = d;
        }

        public void moveBack() {
            x += dx[(d + 2) % 4];
            y += dy[(d + 2) % 4];
        }

        public void rotate() {
            d -= 1;
            if (d < 0) d += 4;
        }
    }
}
