import java.io.*;

public class B1149 {
    static int n;
    static int[][] h = new int[1001][3];
    static String[] ins;
    static int[][] dp = new int[1001][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            h[i][0] = Integer.parseInt(ins[0]);
            h[i][1] = Integer.parseInt(ins[1]);
            h[i][2] = Integer.parseInt(ins[2]);
        }
        dp[0][0] = h[0][0];dp[0][1] = h[0][1];dp[0][2] = h[0][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + h[i][0], dp[i - 1][2] + h[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + h[i][1], dp[i - 1][2] + h[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + h[i][2], dp[i - 1][1] + h[i][2]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[n][i], min);
        }
        bw.write(min + "\n");
        bw.flush();bw.close();
    }
}
