import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class B10844 {
    final static int MOD = 1000000000;
    static int N;
    static long ans;
    static int[][] a = new int[101][11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());ans = 0;

        for (int i = 1; i < 10; i++) {
            a[1][i]++;a[1][10] = 1;
            for (int j = 2; j <= N; j++) {
                for (int k = 0; k < 10; k++) {
                    if (k < 1) {
                        a[j][k] = a[j - 1][k + 1];
                    }else if (k > 8){
                        a[j][k] = a[j - 1][k - 1];
                    }else {
                        a[j][k] = (a[j - 1][k + 1] + a[j - 1][k - 1]) % MOD;
                    }
                    a[j][10] += a[j][k];
                    a[j][10] %= MOD;
                }
            }
            ans += a[N][10];
            ans %= MOD;
            for (int j = 1; j <= N; j++) {
                Arrays.fill(a[j], 0);
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
