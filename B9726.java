import java.util.Scanner;

public class B9726 {
    static int T, t = 0;
    static long n;
    static long[] positive = new long[32];
    static long[] negative = new long[32];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();binaryInit();
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            negativeBinary(n);
        }
    }
    public static void negativeBinary(long n) {

    }
    public static void binaryInit() {
        positive[0] = 1;
        negative[0] = -2;
        for (int i = 1; i < 32; i++) {
            positive[i] = positive[i - 1] << 2;
            negative[i] = negative[i - 1] << 2;
        }
    }
}
