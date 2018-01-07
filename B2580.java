import java.io.*;
import java.util.ArrayList;

public class B2580 {
    static int[][] map = new int[10][10];
    static int[][] minimap = new int[3][3];
    static String[] ins;
    static ArrayList<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 9; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(ins[j]);
                map[i][9] += map[i][j];
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[9][i] += map[j][i];
            }
        }
        for (int i = 0; i < 7; i += 3) {
            for (int j = 0; j < 7; j += 3) {
                int s = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        s += map[k][l];
                    }
                }
                minimap[i / 3][j / 3] = s;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }
        dfs(0, map, minimap);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(((j < 8) ? map[i][j] + " " : map[i][j]));
            }
            sb.append("\n");
        }
        bw.write(sb.toString());bw.flush();
        bw.close();
    }


    public static boolean dfs(int idx, int[][] m, int[][] mm) {
        boolean isSudoku = false;
        if (idx == list.size()) {
            if (isSudoku(m, mm)) {
                isSudoku = true;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        map[i][j] = m[i][j];
                    }
                }
                return isSudoku;

            }else return isSudoku;
        }else {
            int x = list.get(idx).x;
            int y = list.get(idx).y;
            for (int i = 1; i < 10; i++) {
                if (possibleNumbers(x, y, m, i)) {
                    m[x][y] = i;
                    m[x][9] += m[x][y];
                    m[9][y] += m[x][y];
                    mm[x / 3][y / 3] += m[x][y];
                    if (cutBranch(x, y, m, mm)) {
                        if (dfs(idx + 1, m, mm)) {
                            isSudoku = true;
                            return isSudoku;
                        }
                    }
                    m[x][9] -= m[x][y];
                    m[9][y] -= m[x][y];
                    mm[x / 3][y / 3] -= m[x][y];
                    m[x][y] = 0;
                }
            }
        }
        return isSudoku;
    }

    private static boolean isSudoku(int[][] m, int[][] mm) {
        boolean isSudoku = true;
        final int S = 45;
        for (int i = 0; i < 9; i++) {
            if (m[i][9] != S) {isSudoku = false;break;}
            if (m[9][i] != S) {isSudoku = false;break;}
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mm[i][j] != S) {
                    isSudoku = false;break;
                }
            }
        }
        return isSudoku;
    }

    private static boolean cutBranch(int a, int b, int[][] m, int[][] mm) {
        boolean isSudoku;
        isSudoku = (m[a][9] <= 45);
        if (isSudoku) isSudoku = (m[9][b] <= 45);
        int x = a / 3, y = b / 3;
        if (isSudoku) isSudoku = (mm[x][y] <= 45);
        return isSudoku;
    }

    private static boolean possibleNumbers(int a, int b, int[][] m, int num) {
        boolean[] r = new boolean[10];
        boolean[] c = new boolean[10];
        boolean[] mini = new boolean[10];
        for (int i = 0; i < 9; i++) {
            c[map[a][i]] = true;
        }
        for (int i = 0; i < 9; i++) {
            r[map[i][b]] = true;
        }
        int x = a - (a % 3), y = b - (b % 3);
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                mini[map[i][j]] = true;
            }
        }
        return (!c[num] && !r[num] && !mini[num]);
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
