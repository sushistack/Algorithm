import java.util.Scanner;

public class BaekJoon13458 {
    static long N, B, C, count;
    static long[] A = new long[1000005];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);count = 0;
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        B = sc.nextInt();C = sc.nextInt();
        for (int i = 0; i < N; i++) {
            A[i] -= B;count++;
            if (A[i] > 0) {
                long temp = A[i] / C;
                A[i] -= C * temp;count += temp;
                if (A[i] > 0) count++;
            }
        }
        System.out.println(count);
    }
}
