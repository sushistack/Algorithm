import java.io.*;
import java.util.ArrayList;

public class SWE1211 {
    static int t = 10, n, ans, ansIdx;
    static char map[][] = new char[102][102];
    static ArrayList<Point> e = new ArrayList<>();
    static String in;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            ans = Integer.MAX_VALUE;ansIdx = -1;
            for (int i = 1; i < 101; i++) {
                in = br.readLine().replace(" ", "");
                for (int j = 1; j < 101; j++) {
                    map[i][j] = in.charAt(j - 1);
                }
            }
            e.clear();
            for (int i = 1; i < 101; i++) {
                if (map[1][i] == '1') e.add(new Point(1, i, 0));
            }
            for (int i = 0; i < e.size(); i++) {
                flag = false;
                int x = dfs(e.get(i), 0);
                if (ans >= x) {
                    ans = x;ansIdx = e.get(i).y - 1;
                }
            }
            sb.append("#");sb.append(n);sb.append(" ");
            sb.append(ansIdx);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();

    }

    public static int dfs(Point e, int d) {
        if (flag) return 0;
        if (e.x == 100) {
            flag = true;
            return 1;
        }
        int x = 1;
        switch (d) {
            case 0:
                if (map[e.x][e.y - 1] == '1') x += dfs(new Point(e.x, e.y - 1, e.count + 1), 2);
                else if (map[e.x][e.y + 1] == '1') x += dfs(new Point(e.x, e.y + 1, e.count + 1), 1);
                else if (map[e.x + 1][e.y] == '1') x += dfs(new Point(e.x + 1, e.y, e.count + 1), 0);
            case 1:
                if (map[e.x][e.y + 1] == '1') x +=  dfs(new Point(e.x, e.y + 1, e.count + 1), 1);
                else if (map[e.x + 1][e.y] == '1') x += dfs(new Point(e.x + 1, e.y, e.count + 1), 0);
            case 2:
                if (map[e.x][e.y - 1] == '1') x +=  dfs(new Point(e.x, e.y - 1, e.count + 1), 2);
                else if (map[e.x + 1][e.y] == '1') x += dfs(new Point(e.x + 1, e.y, e.count + 1), 0);
        }
        return x;
    }

    private static class Point {
        int x, y, count;
        Point(int x, int y, int count) {
            this.x = x; this.y = y;
            this.count = count;
        }
    }
}
