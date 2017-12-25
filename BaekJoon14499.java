import java.util.Scanner;

public class BaekJoon14499 {
    static int N, M, X, Y, K, c;
    static int[][] planes = {{-1, 0, -1}, {0, 0, 0}, {-1, 0, -1}, {-1, 0, -1}};
    static int[][] table;
    //static int
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();
        X = sc.nextInt();Y = sc.nextInt();
        K = sc.nextInt();table = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < K; i++) {
            c = sc.nextInt();
        }
    }

}
