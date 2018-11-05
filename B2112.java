import java.io.*;

public class B2112 {
    static int t, T, d, w, k, v, ans;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            d = Integer.parseInt(ins[0]);
            w = Integer.parseInt(ins[1]);
            k = Integer.parseInt(ins[2]);
            int map[] = new int[13];
            for (int i = 0; i < d; i++) {
                map[i] = Integer.parseInt(br.readLine().replace(" ", ""), 2);
            }
            ans = k;
            for (int i = 0; i < k; i++) {
                if (dfs(0, i, map, 0, -1)) {
                    ans = i; break;
                }
            }
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
    private static boolean dfs(int c, int idx, int[] map, int status, int prev) {
        if (c == idx) return isPass(map);
        boolean ans = false;
        for (int i = prev + 1; i < d; i++) {
            if ((status & (1 << i)) != 0) continue;
            int temp = map[i];
            map[i] = 0;
            ans = dfs(c + 1, idx, map, status | (1 << i), i);
            if (ans) break;
            map[i] = -1;
            ans = dfs(c + 1, idx, map, status | (1 << i), i);
            map[i] = temp;
            if (ans) break;
        }
        return ans;
    }

    private static boolean isPass(int[] map) {
        int status = 0;
        for (int i = 0; i < d - k + 1; i++) {
            int x = map[i], y = ~map[i];
            for (int j = 1; j < k; j++) {
                x &= map[i + j];
                y &= ~map[i + j];
            }
            status |= x;
            status |= y;
        }
        for (int i = 0; i < w; i++)
            if ((status & (1 << i)) == 0) return false;
        return true;
    }

}
