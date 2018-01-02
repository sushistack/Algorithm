import java.io.*;

public class CF21C {
    static int n;
    static long a[], s[], dp[], sum, t, count = 0;
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        a = new long[n];dp = new long[n];s = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ins[i]);
            s[i] = (i == 0) ? a[i] : s[i - 1] + a[i];
        }
        sum = s[n - 1];
        if (sum % 3 == 0) {
            t = sum / 3;
            dp[n - 1] = (a[n - 1] == t) ? 1 : 0;
            for (int i = n - 2; i > 0; i--) {
                dp[i] = dp[i + 1];
                dp[i] += (s[n - 1] - s[i - 1] == t) ? 1 : 0;
            }
            for (int i = 0; i < n - 2; i++) {
                count += (s[i] == t) ? dp[i + 2] : 0;
            }
        }else count = 0;
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
