import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
// 미해결
public class B1261 {
    static int N, M;
    static int[][] table = new int[101][101];
    static String str;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); N = sc.nextInt();sc.nextLine();
        for (int i = 1; i <= N; i++) {
            str = sc.nextLine();
            for (int j = 1; j <= M; j++) {
                table[i][j] = str.charAt(j - 1) - 48;
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        boolean[][] visit = new boolean[101][101];
        Queue<Point> q = new PriorityQueue<>();
        q.offer(new Point(1,1, 0));
        visit[1][1] = true;
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == N && cur.y == M) list.add(cur.c);
            if (cur.x < N) {
                visit[cur.x + 1][cur.y] = true;
                if (table[cur.x + 1][cur.y] == 0) q.offer(new Point(cur.x + 1, cur.y, cur.c));
                else q.offer(new Point(cur.x + 1, cur.y, cur.c + 1));
            }
            if (cur.y < M) {
                visit[cur.x][cur.y + 1] = true;
                if (table[cur.x][cur.y + 1] == 0) q.offer(new Point(cur.x, cur.y + 1, cur.c));
                else q.offer(new Point(cur.x, cur.y + 1, cur.c + 1));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = (min > list.get(i)) ? list.get(i) : min;
        }
        return min;
    }

    private static class Point implements Comparable<Point> {
        int x, y, c;
        Point(int x, int y, int c) {
            this.x = x; this.y = y; this.c = c;
        }
        @Override
        public int compareTo(Point p) {
            return (c > p.c) ? -1 : 1;
        }
    }
}
