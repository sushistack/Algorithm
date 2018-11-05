import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KBL3_Hanoi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution(2) + "\n");
        bw.flush();bw.close();
    }

    private static class Solution {
        public int[][] solution(int n) {
            int[][] answer = {};
            List<int[]> aList = new ArrayList<>();
            recursiveHanoi(n, 1, 3, 2, aList);
            return aList.stream().map(i -> i).toArray(int[][]::new);
        }

        private void recursiveHanoi (int _n, int _from, int _to, int _tmp, List<int[]> answer) {
            if(_n<1) return;
            recursiveHanoi (_n-1, _from, _tmp, _to, answer);//a를 c로 이동하는 함수
            int[] a = {_from, _to};
            answer.add(a);
            recursiveHanoi (_n-1, _tmp, _to, _from, answer);//c를 b로 이동하는 함수
        }
    }
}
