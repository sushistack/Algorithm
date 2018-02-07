import java.io.*;
import java.util.Arrays;

public class B2294 {
    final static int INF = 987654321;
    static int n, k, c[] = new int[101], dp[] = new int[10001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i + c[j];
                if (idx > k) continue;
                dp[idx] = Math.min(dp[idx], dp[i] + 1);
            }
        }
        bw.write((dp[k] == INF) ? -1 + "\n" : dp[k] + "\n");
        bw.flush();bw.close();
    }
}
