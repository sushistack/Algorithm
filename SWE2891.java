import java.io.*;
import java.util.ArrayList;

public class SWE2891 {
    static int t, T;
    static String[] ins;
    static Grid[][] g = new Grid[6][6];
    static ArrayList<Pos> p = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            sb.append("#");sb.append(t - T);sb.append(" \n");
            p.clear();flag = false;
            for (int i = 0; i < 6; i++) {
                ins = br.readLine().split(" ");
                for (int j = 0; j < ins.length; j++) {
                    if (ins[j].length() == 1) {
                       g[i][j] = new Grid(Integer.parseInt(ins[j].equals("-") ? "0" : ins[j]), false);
                       if (ins[j].equals("-")) p.add(new Pos(i, j, 0));
                    }else {
                        int n = Integer.parseInt(ins[j].split("")[0].equals("-") ? "0" : ins[j].split("")[0]);
                        int m = Integer.parseInt(ins[j].split("")[2].equals("-") ? "0" : ins[j].split("")[2]);
                        g[i][j] = new Grid(n, m, true);
                        if (ins[j].split("")[0].equals("-")) p.add(new Pos(i, j, 0));
                        if (ins[j].split("")[2].equals("-")) p.add(new Pos(i, j, 1));
                    }
                }
            }
            backTrack(0, g);
        }
        bw.write(sb.toString());bw.flush();
        bw.close();
    }

    private static void backTrack(int idx, Grid[][] grid) {
        if (flag) return;
        if (idx == p.size()) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (grid[i][j].isDivisor) {
                        sb.append(grid[i][j].n);sb.append("/");
                        sb.append(grid[i][j].m);
                    }else {
                        sb.append(grid[i][j].n);
                    }
                    if (j < 5) sb.append(" ");
                }
                sb.append("\n");
            }
            flag = true;
            return;
        }

        Pos cur = p.get(idx);

        boolean[] b = new boolean[11];
        for (int i = 0; i < 6; i++) {
            b[grid[cur.x][i].n] = true;
            b[grid[cur.x][i].m] = true;
        }
        for (int i = 0; i < 6; i++) {
            b[grid[i][cur.y].n] = true;
            b[grid[i][cur.y].m] = true;
        }
        int sx = cur.x / 2, sy = cur.y / 3;
        sx *= 2; sy *= 3;
        for (int i = sx; i < sx + 2; i++) {
            for (int j = sy; j < sy + 3; j++) {
                b[grid[i][j].n] = true;
                b[grid[i][j].m] = true;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (b[i]) continue;
            if (cur.z == 1 && grid[cur.x][cur.y].n > i) continue;
            if (grid[cur.x][cur.y].isDivisor && grid[cur.x][cur.y].m != 0) {
                if (cur.z == 0 && grid[cur.x][cur.y].m < i) continue;
            }
            if (cur.z == 0) grid[cur.x][cur.y].n = i;
            else grid[cur.x][cur.y].m = i;
            backTrack(idx + 1, grid);
            if (cur.z == 0) grid[cur.x][cur.y].n = 0;
            else grid[cur.x][cur.y].m = 0;
            if (flag) return;
        }
    }



    private static void print(Grid[][] grid) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (grid[i][j].isDivisor) System.out.print(grid[i][j].n + "/" + grid[i][j].m);
                else System.out.print(grid[i][j].n);
                if (j < 5) System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static class Pos {
        int x, y, z;
        Pos(int x, int y, int z) {
            this.x = x;this.y = y;this.z = z;
        }
    }

    private static class Grid {
        int n, m;
        boolean isDivisor;
        Grid(int n, int m, boolean isDivisor) {
            this.n = n;this.m = m;this.isDivisor = isDivisor;
        }
        Grid(int n, boolean isDivisor) {
            this.n = n;this.m = 0;this.isDivisor = isDivisor;
        }
    }
}
