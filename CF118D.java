import java.io.*;
import java.util.Arrays;

public class CF118D {
    final static int MOD = 100000000;
    static int foot, horse, k1, k2;
    static String[] ins;
    static int[][] f = new int[101][101], h = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        foot = Integer.parseInt(ins[0]);horse = Integer.parseInt(ins[1]);
        k1 = Integer.parseInt(ins[2]);k2 = Integer.parseInt(ins[3]);
        for (int i = 0; i < 101; i++) {
            Arrays.fill(f[i], -1);
            Arrays.fill(h[i], -1);
        }
        f[0][0] = h[0][0] = 1;
        int ans = (F(foot, horse) + H(foot, horse)) % MOD;
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    public static int F(int fo, int ho) {
        if (fo == 0) return (ho == 0) ? 1 : 0;
        else if (f[fo][ho] != -1) return f[fo][ho];
        else {
            int m = Math.min(fo, k1);
            f[fo][ho] = 0;
            for (int i = 1; i <= m; i++) {
                f[fo][ho] += H(fo - i, ho);
                f[fo][ho] %= MOD;
            }
            return f[fo][ho];
        }
    }
    public static int H(int fo, int ho) {
        if (ho == 0) return (fo == 0) ? 1 : 0;
        else if (h[fo][ho] != -1) return h[fo][ho];
        else {
            int m = Math.min(ho, k2);
            h[fo][ho] = 0;
            for (int i = 1; i <= m; i++) {
                h[fo][ho] += F(fo, ho - i);
                h[fo][ho] %= MOD;
            }
            return h[fo][ho];
        }
    }
}
