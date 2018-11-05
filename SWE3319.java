import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class SWE3319 {
    static final int MOD = 1000000007;
    static int t, n, x;
    static long d;
    static String[] ins;
    static HashMap<Long, int[]> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            d = Long.parseLong(ins[1]);
            x = Integer.parseInt(ins[2]);
            int[] coo = new int[2001];
            Arrays.fill(coo, 0);coo[0] = 1;
            hm.clear();hm.put((long)0, coo);

            bw.write("#" + i + " " + dp(1) + "\n");
            bw.flush();
        }
        bw.close();
    }


    public static int dp(long day) {
        int[] nc = new int[2001], pc = new int[2001];
        for (long t = day; t <= d; t++) {
            System.arraycopy(hm.get(t - 1), 0, pc, 0, n + 1);
            Arrays.fill(nc, 0);
            int m = (int)mp(t - 1);
            for (int i = m; i <= n; i++) {
                for (int j = 0; j < x; j++) {
                    if (isPossibleCookies(t, i + j)){
                        nc[i + j] += pc[i];
                        nc[i + j] %= MOD;
                    }
                    if (i + j == n) break;
                }
            }
            hm.clear();hm.put(t, nc);
        }
        return hm.get(d)[n];
    }

    public static boolean isPossibleCookies(long day, int curCookies) {
        long remainDays = d - day;
        int max = x - 1;
        long maximumCookies = max * remainDays;
        return (n <= maximumCookies + curCookies);
    }

    public static long mp(long day) {
        long remainDays = d - day;
        int max = x - 1;
        long min = n - (remainDays * max);
        if (min < 0) min = 0;
        return min;
    }
}
