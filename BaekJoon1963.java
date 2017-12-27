import java.util.Scanner;

public class BaekJoon1963 {
    static final int MAX = 4;
    static int T;
    static int[] A = new int[4];
    static int[] B = new int[4];
    static String str;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            str = sc.next();
            for (int j = 0; j < MAX; j++) {
                A[j] = str.charAt(j) - 48;
            }
            str = sc.next();
            for (int j = 0; j < MAX; j++) {
                B[j] = str.charAt(j) + -48;
            }

            for (int j = 0; j < MAX; j++) {

            }

        }
    }
    public boolean isPrime(int[] numbers) {
        boolean p = true;
        int num = 0;
        num = numbers[0] * 1000 + numbers[1] * 100 + numbers[2] * 10 + numbers[3];
        for (int i = 2; i < (int)Math.sqrt(num); i++) {
            p = (num % 2 == 0) ? !p : p;
            if (num % 2 == 0) break;
        }
        return p;
    }
}
