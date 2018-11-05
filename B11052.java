import java.io.*;

public class B11052 {
    static int N;
    static int[] p = new int[1001];
    static String[] ins;
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            p[i + 1] = Integer.parseInt(ins[i]);
            dp[i + 1] = p[i + 1];
        }

        for (int j = 1; j <= N; j++) {
            for (int k = 1; k <= N; k++) {
                if (j + k <= N)dp[j + k] = Math.max(dp[j] + p[k], dp[j + k]);
            }
        }

        bw.write(dp[N] + "\n");
        bw.flush();bw.close();
    }


}
