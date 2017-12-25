import java.util.Scanner;

public class FloydWarshall11403 {
    static int N, t;
    static int[][] table = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        floyd();printTable();
    }
    public static void floyd() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    table[j][k] = (table[j][i] == 1 && table[i][k] == 1) ? 1 : table[j][k];
                }
            }
        }
    }
    public static void printTable() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(table[i][j]);
                if (j < N) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
