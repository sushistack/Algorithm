import java.util.Scanner;

public class BaekJoon11728 {
    static int n, m, a, b, indexA, indexB;
    static int[] A, B, Answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();m = sc.nextInt();
        indexA = 0; indexB = 0;
        A = new int[n];B = new int[m];
        Answer = new int[n + m];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        for (int i = 0; i < Answer.length; i++) {
            a = (indexA < n) ? A[indexA] : 1000000007;
            b = (indexB < m) ? B[indexB] : 1000000007;
            Answer[i] = (a < b) ? a : b;
            if (a < b) indexA++;else indexB++;
            System.out.print(Answer[i]);
            if (i < Answer.length - 1) System.out.print(" ");
        }

    }
}
