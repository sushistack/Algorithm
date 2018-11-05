import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SWE1259 {
    static int t, T, n;
    static String ins[];
    static Nail[] ns = new Nail[200001];
    static int[][] dp = new int[200001][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            ins = br.readLine().split(" ");
            for (int i = 0; i < (n << 1); i += 2) {
                ns[i >> 1] = new Nail(Integer.parseInt(ins[i]), Integer.parseInt(ins[i + 1]));
            }
            for (int i = 0; i < 200001; i++) Arrays.fill(dp[i], -1);
            bw.write("#" + (t - T) + " "  + "\n");
            bw.flush();bw.close();
        }
    }
    private static int dfs(int idx, int next) {
        if (idx < 0) return 0;
        if (idx == n) {
          return 0;
        } else if (dp[idx][next] != -1) return dp[idx][next];
        else {
            dp[idx][next] = Math.max(dp[idx][next], dfs(idx - 1, ns[idx].prev) + 1);
            return dp[idx][next];
        }
    }

    private static class Nail {
        int prev, next;
        Nail(int prev, int next) {
            this.prev = prev;this.next = next;
        }
    }
}
