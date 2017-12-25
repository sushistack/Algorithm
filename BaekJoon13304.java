import java.util.Scanner;

public class BaekJoon13304 {
    static int N, K, S, Y, count;
    static int[] A = new int[3];
    static int[][] table = new int[7][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); K = sc.nextInt();
        for (int i = 0; i < N; i++) {
            S = sc.nextInt();Y = sc.nextInt();
            table[Y][S]++;
        }
        for (int i = 1; i < 7; i++) {
            count = 0;
            switch (i) {
                case 1:case 2:
                    for (int j = 0; j < 2; j++) {
                        count+= table[i][j];
                    }
                    A[0] += count;
                    break;
                case 3:case 4:

                    break;
                case 5:case 6:
                    break;
            }
        }
        System.out.println(count);
    }
}
