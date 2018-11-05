import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class KBL3_LongestPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution("baccccccccccab") + "\n");
        bw.flush();bw.close();
    }

    private static class Solution {

        public int solution(String s) {
            if (s.length() == 0) return 0;
            int max = -1;
            String pre, sur;
            Queue<Integer> oddQue = getPalindromeQueue(s, true);
            Queue<Integer> evenQue = getPalindromeQueue(s, false);
            if (oddQue.isEmpty() && evenQue.isEmpty()) return 1;
            if (!evenQue.isEmpty()) max = 2;
            if (!oddQue.isEmpty()) max = 3;

            int i = 2;
            while (!oddQue.isEmpty()) {
                int center = oddQue.poll();
                if (center - i < 0 || center + i + 1 > s.length()) continue;
                pre = s.substring(center - i, center);
                sur = s.substring(center + 1, center + i + 1);
                if (new StringBuilder(pre).reverse().toString().equals(sur)) {
                    max = Math.max(max, pre.length() * 2 + 1);
                    oddQue.offer(center);
                    i++;
                }
            }
            i = 2;
            while (!evenQue.isEmpty()) {
                int center = evenQue.poll();
                if (center - i < 0 || center + i > s.length()) continue;
                pre = s.substring(center - i, center);
                sur = s.substring(center, center + i);
                if (new StringBuilder(pre).reverse().toString().equals(sur)) {
                    max = Math.max(max, pre.length() * 2);
                    evenQue.offer(center);
                    i++;
                }
            }

            return max;
        }

        public Queue<Integer> getPalindromeQueue(String s, boolean isOdd) {
            String pre, sur;
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < s.length() - 1; i++) {
                pre = s.substring(i - 1, i);
                sur = (isOdd) ? s.substring(i + 1, i + 2) : s.substring(i, i + 1);
                if (new StringBuilder(pre).reverse().toString().equals(sur)) {
                    q.offer(i);
                }
            }
            return q;
        }

    }
}
