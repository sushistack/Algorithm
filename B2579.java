import java.io.*;

public class B2579 {
    static int S;
    static int[] score = new int[301];
    static int[][] dp = new int[301][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            score[i + 1] = Integer.parseInt(br.readLine());
        }
        dp[1][1] = score[1];
        dp[1][2] = 0;
        dp[2][1] = score[2];
        dp[2][2] = dp[1][1] + score[2];
        for (int i = 3; i <= S; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + score[i];
            dp[i][2] = dp[i - 1][1] + score[i];
        }

        bw.write(((dp[S][1] < dp[S][2]) ? dp[S][2] : dp[S][1])+ "\n");
        bw.flush();bw.close();
    }

}
