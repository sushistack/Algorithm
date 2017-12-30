import java.io.*;
//DP[i] = (i번째 수를 구간의 마지막으로 하는 최대 연속구간합)
public class B1912 {
    static int N, max = Integer.MIN_VALUE;
    static int[] a = new int[100001];
    static int[] dp = new int[100001];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(ins[i]);
            max = Math.max(max, a[i]);
        }
        dp[0] = a[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
        }
        bw.write(max + "\n");
        bw.flush();bw.close();
    }
}
