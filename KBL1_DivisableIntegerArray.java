import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KBL1_DivisableIntegerArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[] arr = {5, 9, 7, 10};
        s.solution(arr, 5);
        bw.flush();bw.close();
    }

    private static class Solution {
        public int[] solution(int[] arr, int divisor) {
            List<Integer> answer = new ArrayList<>();
            int[] t = {-1};

            for (int i : arr) {
                if (i % divisor == 0) answer.add(i);
            }

            return (answer.isEmpty()) ? t : answer.stream().sorted().mapToInt(i -> i).toArray();
        }
    }
}
