import java.io.*;
import java.util.Arrays;
//꼭 다시 풀기
public class B1520 {
    static int M, N, ans = 0;
    static String in, ins[];
    static int[][] table = new int[501][501];
    static int[][] dp = new int[501][501];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        M = Integer.parseInt(in.split(" ")[0]);
        N = Integer.parseInt(in.split(" ")[1]);
        for (int i = 0; i < M; i++) {
            ins = br.readLine().split(" ");
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(ins[j]);
            }
        }
        bw.write(dfs(0,0) + "\n");
        bw.flush();bw.close();

    }

    public static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        int n = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) continue;
            if (table[x][y] > table[nx][ny]) n += dfs(nx, ny);
        }
        dp[x][y] = n;
        return n;
    }



}
