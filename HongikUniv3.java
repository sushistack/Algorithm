import java.util.Scanner;

public class HongikUniv3 {
    static int i = 0;
    static int[] dp = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp[0] = sc.nextInt();
        while (dp[i] != 1){
            dp[i + 1] =  (dp[i] % 2 == 0) ? dp[i] / 2 : 3 * dp[i] + 1;
            i++;
        }
        System.out.println(i + 1);
    }
}
