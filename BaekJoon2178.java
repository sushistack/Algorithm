import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2178 {
    static int[][] table;
    static int N, M, count;
    static String input;
    static PointAndCount s;
    static boolean isArrive;
    static Queue<PointAndCount> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();count = 0;
        table = new int[N][M];isArrive = false;
        for (int i = 0; i < N; i++) {
            input = sc.next();
            for (int j = 0; j < M; j++) {
                table[i][j] = (input.split("")[j].equals("1")) ? 1 : 0;
            }
        }
        s = new PointAndCount(0, 0, count);
        if (table[s.x][s.y] == 1) table[s.x][s.y] = -1;
        queue.add(s);
        while (!queue.isEmpty()) {

            PointAndCount p = queue.poll();
            if (p.x == N - 1 && p.y == M - 1) isArrive = true;
            if (p.y + 1 < M && !isArrive) if (table[p.x][p.y + 1] == 1) {
                table[p.x][p.y] = -1;queue.add(new PointAndCount(p.x, p.y + 1, p.count + 1));
            }
            if (p.x + 1 < N && !isArrive) if (table[p.x + 1][p.y] == 1) {
                table[p.x + 1][p.y] = -1;queue.add(new PointAndCount(p.x + 1, p.y, p.count + 1));
            }
            if (p.y > 0 && !isArrive) if (table[p.x][p.y - 1] == 1) {
                table[p.x][p.y - 1] = -1;queue.add(new PointAndCount(p.x, p.y - 1, p.count + 1));
            }
            if (p.x > 0 && !isArrive) if (table[p.x - 1][p.y] == 1) {
                table[p.x - 1][p.y] = -1;queue.add(new PointAndCount(p.x - 1, p.y, p.count + 1));
            }
            if (isArrive)  {
                count = p.count + 1;
                break;
            }
        }
        System.out.println(count);
    }
}
class PointAndCount implements Comparable<PointAndCount> {
    int x, y, count;
    PointAndCount (int x, int y, int count) {
        this.x = x; this.y = y; this.count = count;
    }
    @Override
    public int compareTo(PointAndCount o) {
        return 0;
    }
}
