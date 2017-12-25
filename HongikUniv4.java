import java.util.ArrayList;
import java.util.Scanner;

public class HongikUniv4 {
    static int N, t, min = Integer.MAX_VALUE, ans, indexOfShortZero;
    static ArrayList<Integer> minus = new ArrayList<>();
    static ArrayList<Integer> plus = new ArrayList<>();
    static int[] list, check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();list = new int[N];
        check = new int[N];
        for (int i = 0; i < N; i++) {
            t = sc.nextInt();
            if (t < 0) minus.add(-t);
            else plus.add(t);
        }
        int m = minus.size() - 1, p = 0;
        for (int i = 0; i < N; i++) {
            if (m < 0) {
                list[i] = plus.get(p++);check[i] = 1;
            }
            else if (p >= plus.size()){
                list[i] = minus.get(m--);check[i] = -1;
            }
            else {
                if (minus.get(m) < plus.get(p)) {
                    list[i] = minus.get(m--);check[i] = -1;
                }else {
                    list[i] = plus.get(p++);check[i] = 1;
                }
            }
        }
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            if (Math.abs(check[i + 1] * list[i + 1] + check[i] * list[i]) < min) {
                min = Math.abs(check[i + 1] * list[i + 1] + check[i] * list[i]);
                ans = check[i + 1] * list[i + 1] + check[i] * list[i];
            }
        }
        System.out.println(ans);
    }
}
