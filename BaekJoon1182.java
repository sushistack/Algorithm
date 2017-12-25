import java.util.Scanner;
import java.util.Stack;

/**
 * Created by im501 on 2017-08-24.
 */
public class BaekJoon1182 {
    static int N, S, Answer, numbers[], subSet[], count, index, o;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();S = sc.nextInt();
        numbers = new int[N];Answer = 0;count = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 1; i < N + 1; i++) { // i개로 이루어진 부분 집합.
            Answer = 0; subSet = new int[i];index = 0;

        }
        System.out.println(count);
    }

}
