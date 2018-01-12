import java.io.*;
import java.util.Arrays;

public class CF189A {
    static int n, a, b, c;
    static String ins[];
    static int[] dp = new int[8001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);a = Integer.parseInt(ins[1]);
        b = Integer.parseInt(ins[2]);c = Integer.parseInt(ins[3]);
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] != -1) {
                dp[i + a] = Math.max(dp[i + a], dp[i] + 1);
                dp[i + b] = Math.max(dp[i + b], dp[i] + 1);
                dp[i + c] = Math.max(dp[i + c], dp[i] + 1);
            }
        }
        bw.write(dp[n] + "\n");
        bw.flush();bw.close();

    }
}
