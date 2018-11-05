import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class KakaoBlindDartGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[][] m = {{0, 0}, {1, 1}, {0, 2}, {2, 0}, {2, 2}};
        bw.write(s.solution("1D2S3T*") + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            Stack<Integer> s = new Stack<>();
            int n, area;
            char option;
            for (int i = 0; i < dartResult.length() - 1; i++) {
                char cur = dartResult.charAt(i), next = dartResult.charAt(i + 1);
                if (i > 1 && cur == '0' && dartResult.charAt(i - 1) == '1') continue;
                if ((cur > 47 && cur < 58 && next != '0') || (cur == '1' && next == '0')) {
                    n = (cur == '1' && next == '0') ? 10 : cur - 48;
                    next = (cur == '1' && next == '0') ? dartResult.charAt(i + 2) : next;
                    int p = 0;
                    switch (next) {
                        case 'S' : p = 1; break;
                        case 'D' : p = 2; break;
                        case 'T' : p = 3; break;
                    }
                    s.add((int)Math.pow(n, p));
                    if ((cur == '1' && next == '0') && i + 3 > dartResult.length() - 1) continue;
                    if (i + 2 > dartResult.length() - 1) continue;
                    int o = (cur == '1' && next == '0') ? dartResult.charAt(i + 3) : dartResult.charAt(i + 2);
                    if (!(o == '#' || o == '*')) continue;
                    if (!s.isEmpty()) {
                        int cc = s.pop() * (o == '#' ? -1 : 2), pr;
                        if (!s.isEmpty() && o == '*')  s.push(s.pop() * 2);
                        s.push(cc);
                    }

                }
            }
            while (!s.isEmpty()) {
                answer += s.pop();
            }
            return answer;
        }
    }
}
