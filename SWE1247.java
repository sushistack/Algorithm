import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SWE1247 {
    static int t, T, n, ans;
    static String ins[];
    static Point s, e;
    static ArrayList<Point> ps = new ArrayList<>();
    static int[] c = new int[12];
    static boolean[] visited = new boolean[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            ins = br.readLine().split(" ");
            s = new Point(Integer.parseInt(ins[0]), Integer.parseInt(ins[1]));
            e = new Point(Integer.parseInt(ins[2]), Integer.parseInt(ins[3]));
            ps.clear();
            for (int i = 4; i < (n + 2) * 2; i += 2) {
                ps.add(new Point(Integer.parseInt(ins[i]), Integer.parseInt(ins[i + 1])));
            }
            ans = Integer.MAX_VALUE;
            Arrays.fill(c, -1);Arrays.fill(visited, false);
            dfs(c, 0, visited);
            bw.write("#" + (t - T) + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static void dfs(int[] v, int idx, boolean[] visited) {
        if (idx == n) {
            int dist = d(s, ps.get(v[0]));
            for (int i = 1; i < n; i++) {
                dist += d(ps.get(v[i]), ps.get(v[i - 1]));
            }
            dist += d(e, ps.get(v[n - 1]));
            ans = Math.min(ans, dist);
        }else{
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    v[idx] = i;visited[i] = true;
                    dfs(v, idx + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }


    private static int d(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
