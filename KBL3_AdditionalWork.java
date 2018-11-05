import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class KBL3_AdditionalWork {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[] a = {2, 1, 2};
        bw.write(s.solution(1, a) + "\n");
        bw.flush();bw.close();
    }
    private static class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;
            if (Arrays.stream(works).sum() <= n) return 0;
            int c[] = new int[50001], max = 0, q, r, curCnt;

            for (int w : works) {
                c[w]++;
                max = Math.max(max, w);
            }

            Stack<Integer> s = new Stack<>();

            for (int i = 0; i <= max; i++) {
                if (c[i] == 0) continue;
                s.push(i);
            }

            while (n != 0) {
                int cur = (s.isEmpty()) ? 0 : s.pop();
                int pre = (s.isEmpty()) ? 0 : s.peek();
                if (c[cur] * (cur - pre) > n) {
                    q = n / c[cur];
                    r = n % c[cur];
                    curCnt = c[cur];
                    c[cur] = 0;
                    c[cur - q] += curCnt - r;
                    c[cur - q - 1] += r;
                    n = 0;
                }  else {
                    c[pre] += c[cur];
                    n -= c[cur] * (cur - pre);
                    c[cur] = 0;
                }
            }

            for (int i = 0; i <= max; i++) {
                answer += i * i * c[i];
            }
            return answer;
        }
    }
}
