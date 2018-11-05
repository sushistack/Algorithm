import java.io.*;

public class KBL3_2Tiling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution(4) + "\n");
        bw.flush();bw.close();
    }

    private static class Solution {
        final int MOD = 1000000007;
        int[] dp = new int[60001];
        public int solution(int n) {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

}
