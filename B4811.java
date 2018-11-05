import java.io.*;
import java.util.Arrays;

public class B4811 {
    static int n;
    static String in;
    static Bottle dp[] = new Bottle[61];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!(in = br.readLine()).equals("0")) {
            n = Integer.parseInt(in.replace(" ", ""));
        }
        Arrays.fill(dp, null);
        dp[1] = new Bottle(1, n - 1, 1);
        //Bottle ans = dp(2 * n);
        //bw.write(ans.n + "\n");
        bw.flush();bw.close();
    }

//    private static Bottle dp(int n) {
//        if (dp[n] != null) return dp[n];
//        Bottle prev = dp(n - 1);
//
//
//
//    }

    private static class Bottle {
        long n;
        int w, h;
        Bottle(long n, int w, int h) {
            this.n = n;this.w = w;this.h = h;
        }
    }
}
