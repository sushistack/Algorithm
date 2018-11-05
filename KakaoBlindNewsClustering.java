import java.io.*;

public class KakaoBlindNewsClustering {
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
        public int solution(int n, int[][] data) {
            return 1;
        }
    }
}
