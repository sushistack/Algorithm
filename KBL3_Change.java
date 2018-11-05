import java.io.*;

public class KBL3_Change {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[] money = {1,2,5};
        bw.write(s.solution(5, money) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        final int MOD = 1000000007;
        int dp[] = new int[100001];

        public int solution(int n, int[] money) {
            dp[0] = 1;

            for (int i = 0; i < money.length; i++) {
                for (int j = money[i]; j <= n; j++) {
                    dp[j] += dp[j - money[i]];
                    dp[j] %= MOD;
                }
            }

            return dp[n];
        }
    }
}