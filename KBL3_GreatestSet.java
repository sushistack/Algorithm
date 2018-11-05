import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KBL3_GreatestSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[] a = {2, 1, 2};
        bw.write(s.solution(2, 9) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        public int[] solution(int n, int s) {
            if (s <= n) {
                int a[] = {(s == n) ? 1 : -1};
                return a;
            }

            int q = s / n, r = s % n, a[] = new int[n];
            for (int i = n - 1; i > -1; i--, r--) {
                a[i] = q;
                if (r > 0) a[i]++;
            }
            return a;
        }
    }
}