import java.util.Scanner;

public class HongikUniv8 {
    static int N, M, scale, t;
    static int[][] table = new int[1001][1001];
    static int[][] rowPrefix = new int[1001][1001];
    static int[][] colPrefix = new int[1001][1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();
        scale = (N > M) ? M : N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rowPrefix[i][j] = (j == 0) ? table[i][j] : rowPrefix[i][j - 1] + table[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                colPrefix[j][i] = (j == 0) ? table[j][i] : colPrefix[j - 1][i] + table[j][i];
            }
        }
        if (existClearArea(scale)) System.out.println(scale);
        else {
            if (!existClearArea(1)) System.out.println(0);
            else System.out.println(binarySearch(1, scale));
        }
    }

    public static int binarySearch(int s, int d) {
        if (d - s == 1) {
            if (existClearArea(s)) {
                return (existClearArea(d)) ? d : s;
            }else {
                return d;
            }
        }
        else {
            return existClearArea((s + d) / 2) ?
                    binarySearch((s + d) / 2, d) :
                    binarySearch(1, (s + d) / 2);
        }
    }

    public static boolean existClearArea(int n) {
        int r, c;
        boolean flag = false;
        for (int i = 0; i <= N - n; i++) {
            for (int j = 0; j <= M - n; j++) {
                  r = subAreaRow(i, j, n);
                  c = subAreaCol(i, j, n);
                  if (r == 0 && c == 0) {
                      flag = true;break;
                  }
            }
        }
        return flag;
    }

    public static int subAreaRow(int x, int y, int n) {
        int s = 0;

        for (int i = x; i < x + n; i++) {
            s = rowPrefix[i][y + n - 1] - rowPrefix[i][y] + table[x][y];
            if (s > 0) break;
        }
        if (n == 1) s = table[x][y];
        return s;
    }

    public static int subAreaCol(int x, int y, int n) {
        int s = 0;
        for (int i = y; i < y + n; i++) {
            s = colPrefix[x + n - 1][i] - colPrefix[x][i] + table[x][y];
            if (s > 0) break;
        }
        if (n == 1) s = table[x][y];
        return s;
    }

}
