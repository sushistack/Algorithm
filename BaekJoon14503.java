import java.util.Scanner;

public class BaekJoon14503 {
    static int N, M, r, c, d, count;
    static int[][] table;
    static Point current;
    static boolean isOperate = true;
    final static int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();
        r = sc.nextInt(); c = sc.nextInt();
        current = new Point(r, c);count = 0;
        d = sc.nextInt();table = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        dfs(current);
        System.out.println(count);
    }
    public static void dfs(Point p) {
        if (table[p.x][p.y] == 0)count++;
        table[p.x][p.y] = -1;
        boolean isMove = false;
        int idx = 0;
        while (idx++ < 4) {
            switch (d) {
                case NORTH:d = WEST;
                    if (table[p.x][p.y - 1] == 0) {
                        isMove = true;dfs(new Point(p.x, p.y - 1));
                    }break;
                case EAST:d = NORTH;
                    if (table[p.x - 1][p.y] == 0) {
                        isMove = true;dfs(new Point(p.x - 1, p.y));
                    }break;
                case SOUTH:d = EAST;
                    if (table[p.x][p.y + 1] == 0) {
                        isMove = true;dfs(new Point(p.x, p.y + 1));
                    }break;
                case WEST:d = SOUTH;
                    if (table[p.x + 1][p.y] == 0) {
                        isMove = true;dfs(new Point(p.x + 1, p.y));
                    }break;
            }if (isMove) break;
        }
        if (!isMove) {
            switch (d) {
                case NORTH:
                    if (table[p.x + 1][p.y] == 1) isOperate = false;
                    else dfs(new Point(p.x + 1, p.y));break;
                case EAST:
                    if (table[p.x][p.y - 1] == 1) isOperate = false;
                    else dfs(new Point(p.x, p.y - 1));break;
                case SOUTH:
                    if (table[p.x - 1][p.y] == 1) isOperate = false;
                    else dfs(new Point(p.x - 1, p.y));break;
                case WEST:
                    if (table[p.x][p.y + 1] == 1) isOperate = false;
                    else dfs(new Point(p.x, p.y + 1));break;
            }
        }
        if (!isOperate) return;
    }
}
