import java.io.*;
import java.util.Arrays;

public class CF520B {
    static int n, m, ans = 0;
    static String ins[];
    static int[] dp = new int[20001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        if (m < n) ans = n - m;
        else {
            Arrays.fill(dp, 100000);
            dp[n] = 0;
            for (int i = n; i > 1; i--) {
                dp[i - 1] = dp[i] + 1;
            }
            for (int i = 1; i <= (m << 1); i++) {
                if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            ans = dp(m);
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    public static int dp(int k) {
        if (k > (m << 1)) return 100000;
        if (dp[k] != 100000) return dp[k];
        else {
            if (k % 2 == 0) dp[k] = dp(k >> 1) + 1;
            dp[k] = Math.min(dp[k], dp(k + 1) + 1);
            return dp[k];
        }
    }

}
