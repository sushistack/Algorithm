import java.io.*;
import java.util.Arrays;

public class B1699 {
    final static int INF = 987654321;
    static int n, idx = 0, a[] = new int[350], dp[] = new int[100001], max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        max = initSquare(n);
        Arrays.fill(dp, INF);
        dp[0] = 0;dp[1] = 1; dp[2] = 2;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < max; j++) {
                if (i + a[j] > n) continue;
                dp[i + a[j]] = Math.min(dp[i + a[j]], dp[i] + 1);
            }
        }
        bw.write(dp[n] + "\n");
        bw.flush();bw.close();
    }

    public static int initSquare(int k) {
        int x = 1;a[1] = 1;
        for (int i = 2; i * i < 100500; i++) {
            a[i] = (i * i);
            if (x == 1) x = (k < a[i]) ? i : x;
        }
        return x;
    }
}
