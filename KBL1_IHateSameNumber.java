import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KBL1_IHateSameNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        s.solution(arr);
        bw.flush();bw.close();
    }

    private static class Solution {
        public int[] solution(int[] arr) {
            int before = arr[0];
            List<Integer> answer = new ArrayList<>();
            answer.add(before);
            for (int i = 1; i < arr.length; i++) {
                if (before != arr[i]) {
                    answer.add(arr[i]);
                    before = arr[i];
                }
            }
            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
