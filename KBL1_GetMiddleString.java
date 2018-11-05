import java.io.*;

public class KBL1_GetMiddleString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution("qw"));
        bw.flush();bw.close();
    }

    private static class Solution {
        public String solution(String s) {
            return (s.length() % 2 == 0) ? s.substring(s.length() / 2 - 1, s.length() / 2 + 1) : "" + s.charAt(s.length() / 2);
        }
    }
}
