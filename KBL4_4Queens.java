import java.io.*;

public class KBL4_4Queens {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution(4) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        static int count = 0;

        public int solution(int n) {
            boolean[][] map = new boolean[n][n];
            backtracking(0, map, n);
            return count;
        }

        private static void backtracking(int i, boolean[][] map, int n) {
            if (i == n) {
                count++;
                return;
            }
            for (int j = 0; j < n; j++) {
                if (!isAttackable(i, j, map)) {
                    map[i][j] = true;
                    backtracking(i + 1, map, n);
                    map[i][j] = false;
                }
            }
        }

        private static void print(boolean[][] map) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print((map[i][j] ? 1 : 0) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }


        private static boolean isAttackable(int x, int y, boolean[][] map) {
            for (int i = 0; i < x; i++) {
                if (map[i][y]) return true;
            }

            for (int i = 0; i < y; i++) {
                if (map[x][i]) return true;
            }

            for (int i = 1; i <= (x < y ? x : y); i++) {
                if (map[x - i][y - i]) return true;
            }

            int min = map.length - y - 1 < x ? map.length - y - 1 : x;
            for (int i = 0; i <= min; i++) {
                if (map[x - i][y + i]) return true;
            }

            return false;
        }
    }
}
