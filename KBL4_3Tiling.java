import java.io.*;

public class KBL4_3Tiling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution(8) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        final int MOD = 1000000007;
        public int solution(int n) {
            int answer = 0;
            long f[] = new long[n + 1];
            f[0] = 1;
            f[2] = 3;
            if (n > 3) f[4] = 11;
            for (int i = 4; i <= n; i += 2) {
                f[i] = f[i - 2] * 3;
                f[i] %= MOD;
                for (int j = (i - 4); j >= 0; j -= 2) {
                    f[i] += (2 * f[j]);
                    f[i] %= MOD;
                }
            }

            return (int)f[(n % 2 == 0) ? n : n - 1];
        }
    }
}
