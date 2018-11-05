import java.io.*;
import java.util.Arrays;

public class SWE4013 {
    static int t, T, k, ans, mag[] = new int[4];
    static boolean[] isRotated = new boolean[4], checked = new boolean[4];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                mag[i] = Integer.parseInt(br.readLine().replace(" ", ""), 2);
            }
            ans = 0;
            while (k-- != 0) {
                Arrays.fill(isRotated, false);
                Arrays.fill(checked, false);
                ins = br.readLine().split(" ");
                dfs(Integer.parseInt(ins[0]) - 1, Integer.parseInt(ins[1]), -1);
            }
            for (int i = 0; i < 4; i++) {
                if ((mag[i] & (1 << 7)) != 0) ans += (1 << i);
            }
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void dfs(int idx, int d, int prev) {
        checked[idx] = true;
        isRotated[idx] = rotation(idx, d, prev);
        if (!isRotated[idx]) return;
        switch (idx) {
            case 0:
                if (!checked[idx + 1]) dfs(idx + 1, -d, idx);
                break;
            case 1:case 2:
                if (!checked[idx - 1]) dfs(idx - 1, -d, idx);
                if (!checked[idx + 1]) dfs(idx + 1, -d, idx);
                break;
            case 3:
                if (!checked[idx - 1]) dfs(idx - 1, -d, idx);
                break;
            default: break;
        }
    }

    private static boolean rotation(int idx, int d, int prev) {
        boolean f = (prev == -1);
        if (!f) {
            int x = (-d < 0) ? 1 : -1;
            if (idx > prev) {//이전에 회전한 것이 왼쪽인 경우
                if (((mag[prev] >> 5 + x) & 1) != ((mag[idx] >> 1) & 1)) f = true;
            } else {
                if (((mag[idx] >> 5) & 1) != ((mag[prev] >> 1 + x) & 1)) f = true;
            }
        }
        if (f) {
            boolean flag = false;
            if (d == 1) {
                if ((mag[idx] & 1) != 0) flag = true;
                mag[idx] >>= 1;
                if (flag) mag[idx] |= (1 << 7);
            } else {
                if ((mag[idx] & (1 << 7)) != 0) flag = true;
                mag[idx] &= ~(1 << 7);
                mag[idx] <<= 1;
                if (flag) mag[idx] |= 1;
            }
        }
        return f;
    }

}
