import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall11404 {
    final static int L = 1000000000;
    static int N, M, u, v, w;
    static int table[][] = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            Arrays.fill(table[i], L);
        }
        for (int i = 0; i < M; i++) {
            u = sc.nextInt(); v = sc.nextInt();
            w = sc.nextInt();
            table[u][v] = (table[u][v] > w) ? w : table[u][v];
        }
        floyd();printTable();
    }
    public static void floyd () {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (table[j][k] > table[j][i] + table[i][k]) {
                        table[j][k] = table[j][i] + table[i][k];
                    }
                }
            }
        }
    }
    public static void printTable() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print((table[i][j] == L || i == j) ? 0 : table[i][j]);
                if (j < N) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
