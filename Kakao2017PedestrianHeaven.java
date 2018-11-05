import java.io.*;
import java.util.Arrays;

public class Kakao2017PedestrianHeaven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[][] m = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        bw.write(s.solution(3, 6, m) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        int MOD = 20170805, mm[][] = new int[501][501];
        int dp[][] = new int[501][501];
        public int solution(int m, int n, int[][] map) {
            mm = map;

            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], -1);
            }
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (flag) dp[i][0] = 0;
                else {
                    if (mm[i][0] == 0) dp[i][0] = 1;
                    else {
                        dp[i][0] = 0;
                        if (mm[i][0] == 1) flag = true;
                    }
                }
            }
            flag = false;
            for (int i = 0; i < n; i++) {
                if (flag) dp[0][i] = 0;
                else {
                    if (mm[0][i] == 0) dp[0][i] = 1;
                    else {
                        dp[0][i] = 0;
                        if (mm[0][i] == 1) flag = true;
                    }
                }
            }

            int answer = dp(m - 1, n - 2, 0) + dp(m - 2, n - 1, 1);
            answer %= MOD;
            return answer;
        }

        public int dp(int x, int y, int d) {
            if (dp[x][y] != -1) return dp[x][y];
            if (mm[x][y] == 1) return 0;
            if (mm[x][y] == 2) return (d == 0) ? dp(x, y - 1, 0) : dp(x - 1, y, 1);
            dp[x][y] = dp(x, y - 1, 0) + dp(x - 1, y, 1);
            dp[x][y] %= MOD;
            return dp[x][y];
        }
    }
}