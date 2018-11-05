import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problem1 {
    static int[] unsortedArray;
    static int k, n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();
        Random r = new Random();
        unsortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            unsortedArray[i] = r.nextInt(200);
        }
        Arrays.sort(unsortedArray);
        System.out.println(unsortedArray[k]);
        for (int i = 0; i < unsortedArray.length; i++) {
            System.out.print(unsortedArray[i]);
            if (i < unsortedArray.length - 1) System.out.print(", ");
        }
    }
}
