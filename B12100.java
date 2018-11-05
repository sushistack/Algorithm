import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B12100 {
    static int n, map[][], v, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, ans;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            v = 0;
            while(st.hasMoreTokens()) {
                map[i][v++] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        dfs(0,5, new ArrayList<>());
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    private static void dfs(int i, int cnt, List<Integer> dirs) {
        if (i == cnt) {
            ans = Math.max(ans, getMaxNumberInBlock(dirs));
            return;
        }

        for (int j = 0; j < 4; j++) {
            dirs.add(j);
            dfs(i + 1, cnt, dirs);
            dirs.remove(dirs.size() - 1);
        }
    }

    private static void print(int map[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getMaxNumberInBlock(List<Integer> dirs) {
        int m[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, m[i], 0, n);
        }

        for (int d : dirs) {
            move(d, m);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, m[i][j]);
            }
        }

        return max;
    }

    private static void move(int d, int map[][]) {
        int b[][] = new int[n][n];
        if (d == 1) {
            reflect(map, true);
            reflect(b, true);
        }
        if (d == 3) {
            reflect(map, false);
            reflect(b, false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                swap(i, j, map, b, d);
            }
        }

        if (d == 1) {
            reflect(map, true);
            reflect(b, true);
        }
        if (d == 3) {
            reflect(map, false);
            reflect(b, false);
        }

    }

    private static void swap(int i, int j, int map[][], int b[][], int d) {
        if (d < 2) {
            if (map[j][i] == 0) return;
            int idx = j;
            for (int k = 0; k < j; k++) {
                if (map[k][i] == 0) {
                    int tmp = map[j][i];
                    map[j][i] = map[k][i];
                    map[k][i] = tmp;
                    idx = k;
                    break;
                }
            }
            if (idx > 0 && b[idx - 1][i] == 0 && map[idx][i] == map[idx - 1][i]) {
                map[idx][i] = 0;
                map[idx - 1][i] <<= 1;
                b[idx - 1][i] = 1;
            }
        } else {
            if (map[i][j] == 0) return;
            int idx = j;
            for (int k = 0; k < j; k++) {
                if (map[i][k] == 0) {
                    int tmp = map[i][j];
                    map[i][j] = map[i][k];
                    map[i][k] = tmp;
                    idx = k;
                    break;
                }
            }
            if (idx > 0 && b[i][idx - 1] == 0 && map[i][idx] == map[i][idx - 1]) {
                map[i][idx] = 0;
                map[i][idx - 1] <<= 1;
                b[i][idx - 1] = 1;
            }
        }
    }

    private static void reflect(int[][] map, boolean isTop) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n >> 1); j++) {
                if (isTop) {
                    int tmp = map[j][i];
                    map[j][i] = map[n - j - 1][i];
                    map[n - j - 1][i] = tmp;
                }else {
                    int tmp = map[i][j];
                    map[i][j] = map[i][n - j - 1];
                    map[i][n - j - 1] = tmp;
                }
            }
        }
    }
}
