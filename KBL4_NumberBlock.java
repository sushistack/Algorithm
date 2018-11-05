import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KBL4_NumberBlock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution(1, 10) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        public int[] solution(long start, long end) {
            List<Integer> answer = new ArrayList<>();
            for (long i = start; i <= end; i++) {
                if (i % 2 == 0) answer.add((int)i / 2);
                else {
                    boolean flag = false;
                    for (long j = 3; j * j <= i; j += 2) {
                        if (i % j == 0) {
                            answer.add((int)(i / j));
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        answer.add((i == 1) ? 0 : 1);
                    }
                }
            }
            for (long l : answer) {
                System.out.print(l + " ");
            }
            System.out.println();
            return answer.stream().mapToInt(i -> (int)i).toArray();
        }

    }
}
