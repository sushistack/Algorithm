import java.io.*;

public class B1405 {
    static int n, dx[] = {0, 0, 1, -1}, dy[] = {-1, 1, 0, 0};
    static double pr[] = new double[4], ans = 0;
    static String ins[];
    static boolean[][] visited = new boolean[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        for (int i = 0; i < 4; i++) {
            pr[i] = Double.parseDouble(ins[i + 1]) / 100.;
        }
        dfs(0, new Point(15, 15), 1);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    public static void dfs(int idx, Point p, double prob) {
        if (idx == n) {
            ans += prob;
            return;
        }
        visited[p.x][p.y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i], ny = p.y + dy[i];
            if (!visited[nx][ny]) dfs(idx + 1, new Point(nx, ny), pr[i] * prob);
        }
        visited[p.x][p.y] = false;
    }

    
    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
