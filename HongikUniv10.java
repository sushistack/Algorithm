import java.util.Scanner;

public class HongikUniv10 {
    static int N;
    static int[][] table = new int[20][20];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                table[i][j] = sc.nextInt();
            }
        }

    }
}
