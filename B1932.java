import java.io.*;

public class B1932 {
    static int n;
    static int[][] t = new int[501][501];
    static String[] ins;
    static int[][] dp = new int[502][502];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < i; j++) {
                t[i][j] = Integer.parseInt(ins[j]);
            }
        }
        dp[1][0] = t[1][0];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = j - 1, next = j;
                if (prev > -1) dp[i][j] = dp[i - 1][prev] + t[i][j];
                if (next < i - 1) dp[i][j] = Math.max(dp[i][j], dp[i - 1][next] + t[i][j]);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n][i]);
        }
        bw.write(max + "\n");
        bw.flush();bw.close();
    }
}
