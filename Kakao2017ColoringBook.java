import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Kakao2017ColoringBook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[][] m = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        bw.write(s.solution(6, 4, m) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        boolean v[][] = new boolean[101][101];
        int areaCnt = 0, maxArea = 0, dx[] = {1, -1, 0, 0}, dy[] = {0, 0, 1, -1};
        public int[] solution(int m, int n, int[][] p) {
            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < p[i].length; j++) {
                    if (v[i][j] || p[i][j] == 0) continue;
                    areaCnt++;
                    dfs(new Point(i, j), m, n, p);
                }
            }
            int[] a = {areaCnt, maxArea};
            return a;
        }

        private void dfs(Point p, int m, int n, int[][] pic) {
            Stack<Point> s = new Stack();
            s.push(p);
            v[p.x][p.y] = true;
            int c = 0;
            while (!s.isEmpty()) {
                Point cur = s.pop();
                c++;
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i], ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1
                            || pic[cur.x][cur.y] != pic[nx][ny] || v[nx][ny]) continue;
                    s.push(new Point(nx, ny));
                    v[nx][ny] = true;
                }
            }
            maxArea = Math.max(maxArea, c);
        }

        private class Point {
            int x, y;

            public Point(int x, int y) {
                this.x = x;this.y = y;
            }
        }
    }
}