import java.io.*;

public class SWE3304 {
    static int n, m, T, t;
    static String a, b, ins[];
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        T = t;
        while (T-- != 0) {
        ins = br.readLine().split(" ");
        a = ins[0];b = ins[1];
        m = a.length(); n = b.length();
        dp = new int[m + 1][n + 1];
        for(int i=1; i<= m; i++){
            for(int j=1; j<= n; j++){
                dp[i][j] = (a.charAt(i - 1) == b.charAt(j - 1)) ?
                        dp[i-1][j-1] + 1: Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        bw.write("#" + (t - T) + " " + dp[m][n] + "\n");
        bw.flush();
        }
        bw.close();
    }
}
