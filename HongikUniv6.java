import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class HongikUniv6 {
    final static int INF = 987654321;
    static int N, M, Hx, Hy, Ex, Ey;
    static int[][] table;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        N = Integer.parseInt(ins[0]); M = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        Hx = Integer.parseInt(ins[0]); Hy = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        Ex = Integer.parseInt(ins[0]); Ey = Integer.parseInt(ins[1]);
        table = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            ins = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                table[i][j] = Integer.parseInt(ins[j - 1]);
            }
        }
        bw.write(bfs(new Point(Hx, Hy, (table[Hx][Hy] == 1) ? 1 : 0)) + "\n");
        bw.flush();bw.close();
    }

    public static int bfs(Point s) {
        Queue<Point> q = new LinkedList<>();
        int[][][] visited = new int[N + 1][M + 1][2];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    visited[i][j][k] = INF;
                }
            }
        }
        q.offer(s);visited[s.x][s.y][0] = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;

                if (table[nx][ny] == 0 && (visited[cur.x][cur.y][cur.m] + 1 < visited[nx][ny][cur.m])){
                    visited[nx][ny][cur.m] = visited[cur.x][cur.y][cur.m] + 1;
                    q.offer(new Point(nx, ny, cur.m));
                }

                if (table[nx][ny] == 1 && cur.m == 0 && (visited[cur.x][cur.y][0] + 1 < visited[nx][ny][1])){
                    visited[nx][ny][1] = visited[cur.x][cur.y][0] + 1;
                    q.offer(new Point(nx, ny, 1));
                }
            }
        }
        return (visited[Ex][Ey][0] == INF && visited[Ex][Ey][1] == INF) ? -1 :
                Math.min(visited[Ex][Ey][0], visited[Ex][Ey][1]) - 1;
    }
    private static class Point {
        int x, y, m;
        Point(int x, int y, int m){
            this.x = x; this.y = y;this.m = m;
        }
    }

}
