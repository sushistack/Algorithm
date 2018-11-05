import java.io.*;
import java.util.*;

public class Kakao2017Camping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[][] m = {{0, 0}, {1, 1}, {0, 2}, {2, 0}, {2, 2}};
        bw.write(s.solution(5, m) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        List<Integer> x = new ArrayList<>(), y = new ArrayList<>(), ux, uy;
        public int solution(int n, int[][] data) {
            int ans = 0;
            for (int i = 0; i < n; i++) {
                x.add(data[i][0]);
                y.add(data[i][1]);
            }

            ux = new ArrayList<>(new HashSet<>(x));
            uy = new ArrayList<>(new HashSet<>(y));

            Collections.sort(ux);
            Collections.sort(uy);

            int s[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                int xi = ux.indexOf(data[i][0]);
                int yi = ux.indexOf(data[i][1]);
                data[i][0] = xi;
                data[i][1] = yi;
                s[xi][yi] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    s[i][j] += (i < 1 ? 0 : s[i - 1][j])
                            + (j < 1 ? 0 : s[i][j - 1])
                            - (i > 0 && j > 0 ? s[i - 1][j - 1] : 0);
                }
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue;
                    int sx, sy, ex, ey;
                    sx = Math.min(data[i][0], data[j][0]) + 1;
                    ex = Math.max(data[i][0], data[j][0]) - 1;
                    sy = Math.min(data[i][1], data[j][1]) + 1;
                    ey = Math.max(data[i][1], data[j][1]) - 1;
                    int cnt;
                    if (sx > ex || sy > ey) cnt = 0;
                    else cnt = s[ex][ey] - s[ex][sy - 1] - s[sx - 1][ey] + s[sx - 1][sy - 1];
                    if (cnt == 0) ans++;
                }
            }
            return ans;
        }
    }
}
