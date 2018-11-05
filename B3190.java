import java.io.*;
import java.util.*;

public class B3190 {
    private static int n, k, l, map[][] = new int[101][101];
    private static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
    private static String ins[];
    private static Deque<Point> snake = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], 0);
        }
        while (k-- != 0) {
            ins = br.readLine().split(" ");
            map[Integer.parseInt(ins[0])][Integer.parseInt(ins[1])] = 2;
        }
        l = Integer.parseInt(br.readLine());
        Map<Integer, Character> timeTable = new HashMap<>();
        while (l-- != 0) {
            ins = br.readLine().split(" ");
            timeTable.put(Integer.parseInt(ins[0]) + 1, ins[1].charAt(0));
        }

        snake.addLast(new Point(1, 1, 0));
        map[1][1] = 1;
        int time = 0;
        while (true) {
            time++;
            Point head = snake.peekFirst();
            if (timeTable.containsKey(time)) {
                char c = timeTable.get(time);
                head.d += (c == 'D') ? 1 : -1;
                head.d += (head.d < 0) ? 4 : 0;
                if (head.d > 3) head.d %= 4;
            }
            int nx = head.x + dx[head.d], ny = head.y + dy[head.d];
            if (nx < 1 || nx > n || ny < 1 || ny > n || map[nx][ny] == 1) break;
            snake.addFirst(new Point(nx, ny, head.d));
            if (map[nx][ny] == 0) {
                Point tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }
            map[nx][ny] = 1;

        }
        bw.write(time + "\n");
        bw.flush();bw.close();
    }

    private static class Point {
        int x, y, d;

        public Point(int x, int y, int d) {
            this.x = x;this.y = y;this.d = d;
        }
    }

    private static class Apple {
        int x, y;
        boolean exist;

        public Apple(int x, int y) {
            this.x = x;this.y = y;
            this.exist = true;
        }
    }

}
