import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE1952 {
    static int t, T, n, costs[] = new int[4], sch[] = new int[13], v, min;
    static int dp[][] = new int[13][13];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            v = 0;
            while (st.hasMoreTokens()) {
                costs[v++] = Integer.parseInt(st.nextToken());
            }
            v = 1;
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                sch[v++] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < 13; i++) {
                Arrays.fill(dp[i], 3000001);
            }
            dp[1][1] = (costs[0] * sch[1] < costs[1]) ? costs[0] * sch[1] : costs[1];
            dp[1][3] = costs[2];
            dp[1][12] = costs[3];

            for (int i = 2; i <= 12; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i][i] = Math.min(dp[i][i], dp[j][i - 1] +
                            ((costs[0] * sch[i] < costs[1]) ? costs[0] * sch[i] : costs[1]));
                    if (i + 2 < 13)
                        dp[i][i + 2] = Math.min(dp[i][i + 2], dp[j][i - 1] + costs[2]);
                }
                for (int j = i; j <= 12; j++) {
                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j]);
                    }
                }

            }

            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(dp[12][12]);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }


}
