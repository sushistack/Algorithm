import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWE1868 {
    static int t, T, n;
    static char[][] map = new char[305][305];
    static int[][] isMine = new int[305][305];
    static String in;
    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
    static int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                in = br.readLine();
                for (int j = 1; j <= n; j++) {
                    map[i][j] = in.charAt(j - 1);
                }
            }
            pq.clear();
            countMine();
            int count = 0;
            while (!pq.isEmpty()) {
                Point cur = pq.peek();
                if (map[cur.x][cur.y] == '.') {
                    click(pq.poll());count++;
                } else pq.poll();
            }
            bw.write("#" + (t - T) + " " + count + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static void countMine() {
        for (int i = 1; i <= n; i++) {
            Arrays.fill(isMine[i], 0);
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (map[nx][ny] == '*') {
                        isMine[i][j]++;
                    }
                }
                pq.offer(new Point(i, j, isMine[i][j]));
            }
        }
    }

    public static void click(Point p) {
        if (p.c == 0) {
            for (int k = 0; k < 8; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx < 1 || nx > n || ny < 1 || ny > n || map[nx][ny] != '.') continue;
                map[nx][ny] = (char)(isMine[nx][ny] + 48);
                click(new Point(nx, ny, isMine[nx][ny]));
            }
        }else {
            map[p.x][p.y] = (char)(isMine[p.x][p.y] + 48);
        }
    }


    private static class Point implements Comparable<Point>{
        int x, y, c;
        Point(int x, int y, int c) {
            this.x = x;this.y = y;this.c = c;
        }
        @Override
        public int compareTo(Point p) {
            return c > p.c ? 1 : -1;
        }
    }
}
