import java.io.*;
import java.util.StringTokenizer;

public class SWE4012 {
    static int t, T, n, map[][] = new int[17][17], ans, v, all;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                v = 0;
                while (st.hasMoreTokens()) {
                    map[i][v++] = Integer.parseInt(st.nextToken());
                }
            }


            ans = Integer.MAX_VALUE;
            dfs(0, 0, 0, 0, -1);


            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void dfs(int idx, int status, int a, int b, int prev) {
        if (idx == n) {
            ans = Math.min(ans, Math.abs(a - b));
            return;
        }
        int aa = 0, bb = 0;
        if (idx > 0) {
            for (int j = 0; j < idx; j++) {
                if ((status & (1 << j)) == 0)
                    bb += map[idx][j] + map[j][idx];
                else
                    aa += map[idx][j] + map[j][idx];
            }
        }
        dfs(idx + 1, status, a, b + bb, idx);
        dfs(idx + 1, status | (1 << idx), a + aa, b, idx);

    }
}
