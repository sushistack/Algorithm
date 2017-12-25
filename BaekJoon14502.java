import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon14502 {
    static int N, M, initZeroCount, infectionCount, max, tableOfOneDimension[];
    static int[][] table;
    static ArrayList<Point> viruses = new ArrayList<>();
    static Point[] wallPoint = new Point[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();max = 0;
        table = new int[N][M]; tableOfOneDimension = new int[N * M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();tableOfOneDimension[i * M + j] = table[i][j];
                if (table[i][j] == 2) viruses.add(new Point(i, j));
                initZeroCount += (table[i][j] == 0) ? 1 : 0;
            }
        }
        // if 1 dimension array
        for (int i = 0; i < M * N; i++) {
            if (tableOfOneDimension[i] == 0) wallPoint[0] = new Point(i / M, i % M);
            else continue;
            for (int j = i + 1; j < M * N; j++) {
                if (tableOfOneDimension[j] == 0 && !(wallPoint[0].x == j / M && wallPoint[0].y == j % M))
                    wallPoint[1] = new Point(j / M, j % M);
                else continue;
                for (int k = j + 1; k < M * N; k++) {
                    if (tableOfOneDimension[k] == 0 && !(wallPoint[0].x == k / M && wallPoint[0].y == k % M)
                            && !(wallPoint[1].x == k / M && wallPoint[1].y == k % M)) {
                        wallPoint[2] = new Point(k / M, k % M);
                        allCaseOfLocatingWall(wallPoint);

                    }
                }
            }
        }
        System.out.println(max);
    }
    public static void allCaseOfLocatingWall(Point[] positionOfWall) {
        int[][] tempTable = new int[N][M];
        int wallCount = 3; infectionCount = 0;
        for (int i = 0; i < N; i++) {
            System.arraycopy(table[i], 0, tempTable[i], 0, M);
        }
        for (int i = 0; i < positionOfWall.length; i++) {
            tempTable[positionOfWall[i].x][positionOfWall[i].y] = 1;
        } // locating wall
        for (int i = 0; i < viruses.size(); i++) {
            dfs(tempTable, viruses.get(i));
        } // infection of virus
        max = Math.max((initZeroCount - infectionCount - 3), max);
    }

    public static void dfs(int[][] t, Point p) {
        if (t[p.x][p.y] == 0) infectionCount++; t[p.x][p.y] = 2;
        if (p.x > 0) if (t[p.x - 1][p.y] == 0) dfs(t, new Point(p.x - 1, p.y));
        if (p.x < N - 1) if (t[p.x + 1][p.y] == 0) dfs(t, new Point(p.x + 1, p.y));
        if (p.y > 0) if (t[p.x][p.y - 1] == 0) dfs(t, new Point(p.x, p.y - 1));
        if (p.y < M - 1) if (t[p.x][p.y + 1] == 0) dfs(t, new Point(p.x, p.y + 1));
    }

}
