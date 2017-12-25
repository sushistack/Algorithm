import java.util.Scanner;

public class BaekJoon1992 {
    static int N, pow;
    static boolean[][] table;
    static String Answer, p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); pow = 0;sc.nextLine();
        table = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            p = sc.nextLine();
            for (int j = 0; j < p.length(); j++) {
                table[i][j + 1] = (p.charAt(j) == '1') ? true : false;
            }
        }
        System.out.println(solve(N, 1, 1));
    }
    public static String solve(int size, int x, int y) {
        String str = "";
        boolean flag = false, first = table[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (table[i][j] != first) {
                    str += "(";
                    str += solve(size >> 1, x, y);
                    str += solve(size >> 1, x, (size >> 1) + y);
                    str += solve(size >> 1, (size >> 1) + x, y);
                    str += solve(size >> 1, (size >> 1) + x, (size >> 1) + y);
                    str += ")";
                    flag = true;
                    break;
                }
                if (flag) break;
            }
        }
        if (!flag) str = (first) ? "1" : "0";
        return str;
    }
}
