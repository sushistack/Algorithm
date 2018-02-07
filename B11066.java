import java.io.*;
import java.util.Arrays;

public class B11066 {
    final static int INF = 987654321;
    static int t, k, a[] = new int[501], dp[][] = new int[501][501], prefix[] = new int[501];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            Arrays.fill(a, 0);
            k = Integer.parseInt(br.readLine());
            ins = br.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                a[i + 1] = Integer.parseInt(ins[i]);
                prefix[i + 1] = (i == 0) ? a[i + 1] : a[i + 1] + prefix[i];
            }
            for (int i = 0; i <= k; i++) Arrays.fill(dp[i], -1);
            bw.write(dp(1, k) + "\n");
            bw.flush();
        }
        bw.close();

    }

    public static int dp(int l, int r) {
        if (l == r) return 0;
        if (r - l == 1) return a[l] + a[r];
        if (dp[l][r] != -1) return dp[l][r];
        dp[l][r] = INF;
        for (int i = l; i < r; i++) {
            dp[l][r] = Math.min(dp[l][r], prefix[r] - prefix[l - 1] + dp(l, i) + dp(i + 1, r));
        }

        return dp[l][r];
    }





}
