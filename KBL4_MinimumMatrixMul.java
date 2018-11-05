import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KBL4_MinimumMatrixMul {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[][] m = {{5, 3}, {3, 10}, {10 ,6}};
        bw.write(s.solution(m) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        int dp[][] = new int[201][201];
        public int solution(int[][] m) {
            ArrayList<Integer> mm = new ArrayList<>();
            for (int i = 0; i < m.length; i++) {
                mm.add(m[i][0]);
            }
            mm.add(m[m.length - 1][1]);

            int n = mm.size();
            for (int i = 0; i < n; i++) {
                dp[i][i] = 0;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n - i; j++) {
                    int k = i + j;
                    dp[j][k] = Integer.MAX_VALUE;
                    for (int l = j; l < k; l++) {
                        int a = dp[j][l] + dp[l + 1][k] + mm.get(j - 1) * mm.get(l) * mm.get(k);
                        if (a < dp[j][k]) dp[j][k] = a;
                    }
                }
            }
            
            return dp[1][n - 1];
        }
    }
}
