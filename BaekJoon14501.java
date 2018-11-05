import java.io.*;

public class BaekJoon14501 {
    static int n, t[] = new int[15], p[] = new int[15], ans;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            t[i] = Integer.parseInt(ins[0]);
            p[i] = Integer.parseInt(ins[1]);
        }
        dfs(0, 0, 0);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
    private static void dfs(int day, int c, int status) {
        if (c > 0) c--;
        if (day == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += ((status & (1 << i)) != 0) ? p[i] : 0;
            }
            ans = Math.max(ans, sum);
            return;
        }
        dfs(day + 1, c, status);
        if (c == 0 && day + t[day] <= n) dfs(day + 1, t[day], status | (1 << day));
    }
}
