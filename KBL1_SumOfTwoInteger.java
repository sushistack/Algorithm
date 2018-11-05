import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KBL1_SumOfTwoInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution(1, 3) + "\n");
        bw.flush();bw.close();
    }

    private static class Solution {
        public int solution(int a, int b) {
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            return ((b - a + 1) * (2 * a + b - a)) >> 1;
        }
    }
}
