import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KBL3_HowToLineUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[] a = {2, 1, 2};
        bw.write(s.solution(4, 15) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        public int[] solution(int n, long k) {
            long[] f = new long[n + 1];
            List<Integer> answer = new ArrayList();
            List<Integer> numbers = new LinkedList<>();
            f[1] = 1;
            numbers.add(1);
            for (int i = 2; i < n + 1; i++) {
                f[i] = f[i - 1] * i;
                numbers.add(i);
            }
            for (int i = n; i > 0; i--) {
                long prev = f[i - 1];
                for (int j = 1; j <= i; j++) {
                    if (k <= j * prev) {
                        answer.add(numbers.get(j - 1));
                        k -= (j - 1) * prev;
                        numbers.remove(j - 1);
                        break;
                    }
                }
            }
            answer.add(numbers.get(0));
            return answer.stream().mapToInt(i -> (int)i).toArray();
        }
    }

}