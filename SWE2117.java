import java.io.*;
import java.util.StringTokenizer;

public class SWE2117 {
    static int t, T, n, m, v, map[][] = new int[20][20];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            m = Integer.parseInt(ins[1]);
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                v = 0;
                while (st.hasMoreTokens()) {
                    map[i][v++] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            for (int i = 1; i < n + 5; i++) {
                ans = Math.max(ans, getMaxService(getMask(i - 1), i - 1));
            }
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static int getMaxService(int[][] mask, int k) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, getMaxCustommer(i, j, mask, k));
            }
        }
        return ans;
    }

    private static int getMaxCustommer(int x, int y, int[][] mask, int k) {
        int cost = 0, install = (k * k + (k + 1) * (k + 1)), count = 0;
        for (int i = x - k; i <= x + k; i++) {
            for (int j = y - k; j <= y + k; j++) {
                if (i < 0 || j < 0 || i > n - 1 || j > n - 1) continue;
                cost += ((map[i][j] & mask[i - (x - k)][j - (y - k)]) == 1) ? m : 0;
                count += ((map[i][j] & mask[i - (x - k)][j - (y - k)]) == 1) ? 1 : 0;
            }
        }
        return (cost - install < 0) ? -1 : count;
    }

    private static int[][] getMask(int k) {
        int mask[][] = new int[(k << 1) + 1][(k << 1) + 1];
        for (int i = 0; i < mask.length; i++) {
            for (int j = 0; j < mask.length; j++) {
                if (Math.abs(k - i) + Math.abs(k - j) <= k)
                    mask[i][j] = 1;
            }
        }
        return mask;   
    }


}
