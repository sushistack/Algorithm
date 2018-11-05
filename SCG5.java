import java.io.*;

public class SCG5 {
    final static int MOD = 1000000007;
    static int T, N, M;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            in = br.readLine();
            N = Integer.parseInt(in.split(" ")[0]);
            M = Integer.parseInt(in.split(" ")[1]);
            int ans = 1;
            int min = Math.min(N, M);
            int max = Math.max(N, M);
            for (int i = 0; i < N + M + 1; i++) {
                ans <<= 1;ans %= MOD;
                double t = 1;
                if (i < max) {
                    for (double r = N + M - i, n = M + N; r > min + 1; r--, n--) {
                        t *= (n / r);t %= MOD;
                    }
                    t *= combination(i + min + 1, min + 1);t %= MOD;
                }else {

                }


            }
            ans--;

        }
    }
    public static int combination(int a, int b) {
        return 0;
    }
}
