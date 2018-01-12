import java.io.*;
import java.util.Arrays;

public class SWE1486 {
    static int t, T, n, b, curH;
    static int[] h = new int[21];
    static String ins[];
    static boolean[] table = new boolean[200001];
    static boolean[] bitmask = new boolean[21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            b = Integer.parseInt(ins[1]);
            curH = b;Arrays.fill(h, 0);
            ins = br.readLine().split(" ");
            for (int i = 0; i < n; i++) h[i] = Integer.parseInt(ins[i]);
            Arrays.sort(h, 0, n);
            Arrays.fill(table, false);
            Arrays.fill(bitmask, false);
            dfs(0, bitmask);
            int ans = 0;
            for (int i = b; i < 200001; i++) {
                if (table[i]) break;
                else ans++;
            }
            bw.write("#" + (t - T) + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static void dfs(int idx, boolean[] bit) {
        if (idx == n) {
            int ans = 0;
            for (int i = 0; i < n; i++) if (bit[i]) ans += h[i];
            table[ans] = true;
        }else {
            bit[idx] = true;
            dfs(idx + 1, bit);
            bit[idx] = false;
            dfs(idx + 1, bit);
        }
    }
}
