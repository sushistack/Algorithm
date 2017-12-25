import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon14501 {
    static int N, max = 0;
    static int[] T, P;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pair[] list;
        N = sc.nextInt();T = new int[N + 1];
        P = new int[N + 1];list = new Pair[N + 1];

        for (int i = 1; i < N + 1; i++) {
            T[i] = sc.nextInt();P[i] = sc.nextInt();
            list[i] = new Pair(i, P[i]);
        }
        for (int i = 1; i < list.length; i++) {
            dfs(list[i]);
        }

        System.out.println(max);
    }

    public static void dfs(Pair l) {
            if (l.day + T[l.day] < N + 1) {
                for (int j = l.day + T[l.day]; j < N + 1; j++) {
                    if (j + T[j] <= N + 1) {
                        dfs(new Pair(j, l.pay + P[j]));
                    } else {
                        max = Math.max(l.pay, max);
                    }
                }
            }else if(l.day + T[l.day] == N + 1) {
                max = Math.max(l.pay, max);return;
            }
    }
}
class Pair implements Comparable<Pair> {
    int day, pay;
    Pair(int day, int pay) {
        this.day = day; this.pay = pay;
    }
    @Override
    public int compareTo(Pair o) {
        return 0;
    }
}
