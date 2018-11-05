import java.util.Scanner;

public class NHNEntertainment2 {
    static int n;
    static int[][] table;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        table = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                table[j][i] = sc.nextInt();
            }
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(table[i][j]);
//                if (j < n) System.out.print(" ");
//            }
//            System.out.println();
//        }
    }
}
