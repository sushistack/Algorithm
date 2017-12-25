import java.util.Scanner;

public class BaekJoon3190 {
    static final int UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4;
    static int N, K, L, x, y, s, currentDir = RIGHT, second = -1;
    static char c;
    static int[][] table;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt();
        table = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            x = sc.nextInt();y = sc.nextInt();
            table[x][y] = 1;
        }
        L = sc.nextInt();Directs[] directs = new Directs[L];
        for (int i = 0; i < L; i++) {
            s = sc.nextInt(); c = sc.next().charAt(0);
            directs[i] = new Directs(s, c);
        }
        dfs(1, 1);
    }
    static void dfs(int x, int y) {

    }
    static class Directs {
        int sec;
        char dir;
        Directs(int sec, char dir) {
            this.sec = sec; this.dir = dir;
        }
    }
}
