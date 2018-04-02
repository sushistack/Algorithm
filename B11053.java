import java.io.*;
import java.util.Arrays;

public class B11053 {
    static int n, a[] = new int[1001], dp[] = new int[1001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ins[i]);
        }
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int ans = -1;
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
