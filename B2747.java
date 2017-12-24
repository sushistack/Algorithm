import java.io.*;

public class B2747 {
    static int N;
    static long[] dp = new long[91];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp[0] = 0;dp[1] = 1;dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        bw.write(dp[N] + "\n");
        bw.flush();bw.close();
    }
}
