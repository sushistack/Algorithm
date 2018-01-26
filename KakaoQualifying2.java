import java.io.*;
import java.util.Arrays;

public class KakaoQualifying2 {
    static int MOD = 20170805;
    static int[][] map;
    static int N, M;
    static int[][][] dp = new int[501][501][3];
    static int[] dx = {0, -1};
    static int[] dy = {-1, 0};
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m;
        ins = br.readLine().split(" ");
        m = Integer.parseInt(ins[0]);
        n = Integer.parseInt(ins[1]);
        int[][] cm = new int[m][n];
        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                cm[i][j] = Integer.parseInt(ins[j]);
            }
        }
        bw.write(solution(m, n, cm) + "\n");
        bw.flush();bw.close();
    }

    public static int solution(int m, int n, int[][] cityMap) {
        M = m;N = n;map = cityMap;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);
        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = 1;
        int answer = dp(m - 1, n - 1, 2);
        answer %= MOD;
        return answer;
    }

    public static int dp(int x, int y, int c) {
        if (dp[x][y][c] != -1) return dp[x][y][c];
        else {
            dp[x][y][c] = 0;
            switch (c) {
                case 0:
                    if (y > 0) {
                        if (map[x][y - 1] == 0) dp[x][y][c] += dp(x, y - 1, 2);
                        else if (map[x][y - 1] == 2) dp[x][y][c] += dp(x, y - 1, 0);
                    }
                    break;
                case 1:
                    if (x > 0) {
                        if (map[x - 1][y] == 0) dp[x][y][c] += dp(x - 1, y, 2);
                        else if (map[x - 1][y] == 2) dp[x][y][c] += dp(x - 1, y, 1);
                    }
                    break;
                case 2:
                    if (y > 0) {
                        if (map[x][y - 1] == 0) dp[x][y][c] += dp(x, y - 1, 2);
                        else if (map[x][y - 1] == 2) dp[x][y][c] += dp(x, y - 1, 0);
                    }
                    if (x > 0) {
                        if (map[x - 1][y] == 0) dp[x][y][c] += dp(x - 1, y, 2);
                        else if (map[x - 1][y] == 2) dp[x][y][c] += dp(x - 1, y, 1);
                    }
                    dp[x][y][c] %= MOD;
                    break;
            }

            return dp[x][y][c];
        }
    }
}
