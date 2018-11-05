import java.util.Random;
import java.util.Scanner;

public class Problem2 {
    static int[] numbers;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        n = sc.nextInt();numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(10000);
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "는 소수가 ");
            System.out.println((!isPrime(numbers[i])) ? "맞다": "아니다.");
        }
    }
    public static boolean isPrime(int n) {
        boolean isPrime = true;
        for (int i = 2 ; i * i <= n; i++) {
            if (i % n == 0) {
                isPrime = false; break;
            }
        }
        return isPrime;
    }
}
