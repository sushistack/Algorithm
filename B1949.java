import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class B1949 {
    static int n, u, v, a[] = new int[10001], dp[][] = new int[10001][2];
    static String ins[];
    static ArrayList<Integer>[] g = new ArrayList[10001];
    static boolean visited[] = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += a[i] = Integer.parseInt(ins[i - 1]);
            g[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 2; j++)
                dp[i][j] = -1;

        for (int i = 1; i < n; i++) {
            ins = br.readLine().split(" ");
            u = Integer.parseInt(ins[0]);
            v = Integer.parseInt(ins[1]);
            g[u].add(v);g[v].add(u);
        }
        int p = dp(1, 1, 1);
        Arrays.fill(visited, false);
        int q = dp(1, 0, 1);
        bw.write(Math.max(p, q) + "\n");
        bw.flush();bw.close();
    }

    public static int dp(int v, int b, int prev) {
        if (dp[v][b] != -1) return dp[v][b];
        visited[v] = true;
        dp[v][b] = (b == 1) ? a[v] : 0;
        for (int i = 0; i < g[v].size(); i++) {
            int next = g[v].get(i);
            if (next != prev)
                dp[v][b] += (b == 1) ? dp(next, 0, v) : Math.max(dp(next, 0, v), dp(next, 1, v));
        }
        return dp[v][b];
    }
}
