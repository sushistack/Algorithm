import java.io.*;

public class KBL4_FIFOScheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[] cores = {1, 2, 3};
        bw.write(s.solution(6, cores) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        public int solution(int n, int[] cores) {
            if (cores.length >= n) return cores[n - 1];
            int sum = cores.length, answer = -1, t = 1;

            while (true) {
                for (int i = 0; i < cores.length; i++) {
                    sum += (t % cores[i] == 0) ? 1 : 0;
                    if (sum == n) {
                        answer = i + 1;
                        break;
                    }
                }
                if (answer != -1) break;
                t++;
            }
            return answer;
        }

    }
}
