import java.util.Scanner;
import java.util.Stack;

public class BaekJoon13460 {
    static String[][] table;
    static int N, M;
    static boolean isEscape;
    static int[] directs = new int[1000];
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();
        table = new String[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.next();
            }
        }


    }
    public static void dfs(int x, int y) {
        if (table[x][y].equals("O")) isEscape = true;
        if (table[x - 1][y].equals(".") && x > 0) dfs(x - 1, y);
        if (table[x + 1][y].equals(".") && x < N - 1) dfs(x + 1, y);
        if (table[x][y - 1].equals(".") && y > 0) dfs(x, y - 1);
        if (table[x][y + 1].equals(".") && y < M - 1) dfs(x, y + 1);



    }

}
