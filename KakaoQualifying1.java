import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoQualifying1 {
    static boolean[][] visited = new boolean[101][101];
    static int numberOfArea = 0, maxSizeOfOneArea = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int tm, tn;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n1, m1;
        n1 = Integer.parseInt(br.readLine());
        m1 = Integer.parseInt(br.readLine());
        int[][] map = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < m1; j++) {
                map[i][j] = Integer.parseInt(ins[j]);
            }
        }

        int[] t = solution(m1, n1, map);
        bw.write(t[0] + " " + t[1] + "\n");
        bw.flush();bw.close();
    }
    public static int[] solution(int m, int n, int[][] picture) {
        tm = m;tn = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(new Point(i, j), picture[i][j], picture);
                    numberOfArea++;
                    print();
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void print() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tn; i++) {
            for (int j = 0; j < tm; j++) {
                sb.append(visited[i][j] ? 1 : 0);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void bfs(Point p, int v, int[][] picture) {
        Queue<Point> q = new LinkedList<>();
        visited[p.x][p.y] = true;
        q.offer(p);
        int count = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 0 || nx > tn - 1 || ny < 0 || ny > tm - 1) continue;
                if (!visited[nx][ny] && picture[nx][ny] == v) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
            count++;
        }
        maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
