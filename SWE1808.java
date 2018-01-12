import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SWE1808 {
    final static int INF = Integer.MAX_VALUE;
    static int t, T, n, ans;
    static String ins[];
    static boolean[] btn = new boolean[10];
    static int[] dp = new int[1000001];
    static ArrayList<Integer> divisors = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            for (int i = 0; i < 10; i++) {
                btn[i] = (ins[i].equals("1"));
            }
            ans = Integer.MAX_VALUE;
            Arrays.fill(dp, INF);
            for (int i = 0; i < 10; i++) if (btn[i]) dp[i] = 1;

            n = Integer.parseInt(br.readLine());
            int a = dfs(n);
            ans = (a != INF) ? a + 1 : -1;
            bw.write("#" + (t - T) + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }


    public static int dfs(int d) {
        if (isPossibleNumber("" + d)) dp[d] = Math.min(dp[d], ("" + d).length());
        if (dp[d] != INF) return dp[d];
        else {
            ArrayList<Integer> a = getDivisors(d);
            for (int i = 0; i < a.size(); i++) {
                int n1 = dfs(a.get(i));
                int n2 = dfs(d / a.get(i));
                if (n1 == INF || n2 == INF) continue;
                dp[d] = Math.min(dp[d], n1 + n2 + 1);
            }
            return dp[d];
        }
    }


    public static boolean isPossibleNumber (String s) {
        boolean isPossible = true;
        for (int i = 0; i < s.length(); i++) {
            if (!btn[s.charAt(i) - 48]) {
                isPossible = false; break;
            }
        }
        return isPossible;
    }

    private static ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> l = new ArrayList<>();
        double m = Math.sqrt(n);
        int floorM = (int)m;
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) l.add(i);
        }
        return l;
    }


}
