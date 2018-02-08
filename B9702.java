import java.io.*;
import java.util.Arrays;

public class B9702 {
    static int t, T, n, dp[] = new int[501], a[] = new int[501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            Arrays.fill(dp, -1);
            for (int i = 0; i <= n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i <= n; i++) {
                ans += dp[i];
            }

            bw.write("Case #" + (t - T) + ": " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }
}
