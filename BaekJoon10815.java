import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon10815 {
    static int N, M;
    static int[] takenCards;
    static int[] givenCards;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();takenCards = new int[N];
        for (int i = 0; i < N; i++) {
            takenCards[i] = sc.nextInt();
        }
        Arrays.sort(takenCards);M = sc.nextInt();
        givenCards = new int[M];
        for (int i = 0; i < M; i++) {
            givenCards[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            System.out.print((Arrays.binarySearch(takenCards, givenCards[i]) < 0) ? 0 : 1);
            if (i < M - 1) System.out.print(" ");
        }
    }
}
