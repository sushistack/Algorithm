import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SWE1865 {
    static int t, T, n, idx;
    static double p[][] = new double[16][16], ans, max;
    static ArrayList<Data>[] dp = new ArrayList[17];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 17; i++) dp[i] = new ArrayList<>();
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            ans = 1.;
            for (int i = 0; i <= n; i++) dp[i].clear();
            for (int i = 1; i <= n; i++) {
                ins = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    p[i][j] = (double)Integer.parseInt(ins[j]) / 100.;
                }
            }
            dp[0].add(new Data(1., 0));
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < dp[i - 1].size(); j++) {
                    Data d = dp[i - 1].get(j);
                    for (int k = 0; k < n; k++) {
                        if ((d.status & (1 << k)) == 0) {
                            int s = d.status + (1 << k);
                            dp[i].add(new Data(d.v * p[i][k], s));
                        }
                    }
                }
            }
            ans = Collections.max(dp[n]).v;

            ans *= 100;
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(String.format("%.6f", ans));sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static class Data implements Comparable<Data> {
        double v;

        @Override
        public int compareTo(Data o) {
            return this.v > o.v ? 1 : -1;
        }

        int status;
        Data(double v, int status) {
            this.v = v;this.status = status;
        }
    }
}

