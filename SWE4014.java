import java.io.*;
import java.util.StringTokenizer;

public class SWE4014 {
    static int t, T, n, x, map[][] = new int[20][20], v;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            x = Integer.parseInt(ins[1]);
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                v = 0;
                while (st.hasMoreTokens()) {
                    map[i][v++] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += getNumOfInstall(i, 0, map);
                ans += getNumOfInstall(i, 1, map);
            }

            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static int getNumOfInstall(int m, int r, int[][] mp) {
        boolean isPath = true, load[] = new boolean[n];
        int map[][] = new int[20][20];
        if (r == 0) map = mp;
        else {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    map[j][i] = mp[i][j];
                }
            }
        }
        if (map[m][0] < map[m][1] || map[m][n - 2] > map[m][n - 1]) return 0;
        for (int i = 0; i < n - 1; i++) {
            int cur = map[m][i], next = map[m][i + 1];
            if (cur == next) continue;
            if (Math.abs(cur - next) > 1) return 0;
            if (cur - next == 1) {
                if (isFlat(next, i + 2, i + x  + 1, m, map, load)) {
                    for (int j = 1; j < x + 1; j++) load[i + j] = true;
                } else isPath = false;
            }else {
                if (isFlat(map[m][i - 1], i - x + 1, i, m, map, load)) {
                    for (int j = i - x + 1; j <= i; j++) load[j] = true;
                } else isPath = false;
            }
            if (!isPath) return 0;
        }
        return 1;
    }


    private static boolean isFlat(int standard, int s, int e, int m, int[][] map, boolean[] l) {
        if (s < 0 || e > n) return false;
        for (int i = s; i < e; i++) {
            if (l[i]) return false;
            if (standard != map[m][i]) return false;
        }
        return true;
    }
}
