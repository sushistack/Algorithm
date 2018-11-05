import java.io.*;
import java.util.StringTokenizer;

public class SWE4008 {
    static int t, T, n, v, l, min, max, op[] = new int[4];
    static char[] fomu = new char[30];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            StringTokenizer st;
            n = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;max = Integer.MIN_VALUE;
            v = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                op[v++] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            v = 0;
            while (st.hasMoreTokens()) {
                fomu[v] = st.nextToken().charAt(0);
                v += 2;
            }
            l = (n << 1) - 1;
            dfs(0, fomu, op);
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(max - min);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void dfs(int idx, char[] f, int[] op) {
        if (idx == n - 1) {
            int ans = f[0] - 48;
            for (int i = 1; i < l - 1; i += 2) {
                switch (f[i]) {
                    case '+': ans += f[i + 1] - 48; break;
                    case '-': ans -= f[i + 1] - 48; break;
                    case '*': ans *= f[i + 1] - 48; break;
                    case '/': ans /= f[i + 1] - 48; break;
                }
            }
            min = Math.min(min, ans);
            max = Math.max(max, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0: f[(idx << 1) + 1] = '+'; break;
                    case 1: f[(idx << 1) + 1] = '-'; break;
                    case 2: f[(idx << 1) + 1] = '*'; break;
                    case 3: f[(idx << 1) + 1] = '/'; break;
                }
                dfs(idx + 1, f, op);
                op[i]++;
            }
        }
    }



}
