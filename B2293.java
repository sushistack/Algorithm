import java.io.*;
// 다시 해볼것
public class B2293 {
    static int N, K, max = 0;
    static String in;
    static int[] dp = new int[10001];
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        N = Integer.parseInt(in.split(" ")[0]);
        K = Integer.parseInt(in.split(" ")[1]);
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        bw.write(dp[K] + "\n");
        bw.flush();bw.close();
    }
}
