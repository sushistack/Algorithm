import java.util.*;

public class HongikUniv6 {
    static int N, M, Hx, Hy, Ex, Ey;
    static int[][] table;
    static Point source, destination;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        Hx = sc.nextInt();Hy = sc.nextInt();
        Ex = sc.nextInt();Ey = sc.nextInt();
        table = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        boolean[][] visit = new boolean[N + 1][M + 1];
        source = new Point(Hx, Hy,0);
        destination = new Point(Ex, Ey, 0);
        int d = bfs(source);
        System.out.println(d);
    }

    public static int bfs(Point s) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visit = new boolean[N + 1][M + 1];
        q.offer(s);
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == destination.x && cur.y == destination.y) return cur.count;
            if (cur.y < M) {
                if (table[cur.x][cur.y + 1] == 0 && !visit[cur.x][cur.y + 1]) {
                    visit[cur.x][cur.y + 1] = true;
                    q.offer(new Point(cur.x, cur.y + 1, cur.count + 1));
                }
            }
            if (cur.x < N) {
                if (table[cur.x + 1][cur.y] == 0 && !visit[cur.x + 1][cur.y]) {
                    visit[cur.x + 1][cur.y] = true;
                    q.offer(new Point(cur.x + 1, cur.y, cur.count + 1));
                }
            }
            if (cur.y > 1) {
                if (table[cur.x][cur.y - 1] == 0 && !visit[cur.x][cur.y - 1]) {
                    visit[cur.x][cur.y - 1] = true;
                    q.offer(new Point(cur.x, cur.y - 1, cur.count + 1));
                }
            }
            if (cur.x > 1) {
                if (table[cur.x - 1][cur.y] == 0 && !visit[cur.x - 1][cur.y]) {
                    visit[cur.x - 1][cur.y] = true;
                    q.offer(new Point(cur.x - 1, cur.y, cur.count + 1));
                }
            }
        }
        return -1;
    }
    private static class Point {
        int x, y, count;
        
        Point(int x, int y,int count ){
            this.x = x; this.y = y;
            this.count = count;
            
        }
    }

}
