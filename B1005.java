import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class B1005 {
    static int T, n, k, x, y, w;
    static String[] ins;
    static int[] d = new int[1005];
    static long[] dp = new long[1005];
    static ArrayList<Integer>[] pre = new ArrayList[1005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < 1005; i++) {
            pre[i] = new ArrayList<>();
        }
        for (int i = 0; i < T; i++) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            k = Integer.parseInt(ins[1]);
            ins = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                d[j] = Integer.parseInt(ins[j - 1]);
            }
            for (int j = 1; j <= n; j++) {
                pre[j].clear();
            }
            for (int j = 0; j < k; j++) {
                ins = br.readLine().split(" ");
                x = Integer.parseInt(ins[0]);
                y = Integer.parseInt(ins[1]);
                pre[y].add(x);
            }
            w = Integer.parseInt(br.readLine());
            Arrays.fill(dp, -1);
            for (int j = 1; j <= n; j++) {
                if (pre[j].isEmpty()) dp[j] = d[j];
            }
            bw.write(dp(w) + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static long dp (int n) {
        if (dp[n] != -1) return dp[n];
        else {
            dp[n] = dp(pre[n].get(0)) + d[n];
            for (int i = 0; i < pre[n].size(); i++) {
                dp[n] = Math.max(dp[n], dp(pre[n].get(i)) + d[n]);
            }
            return dp[n];
        }

    }
}
