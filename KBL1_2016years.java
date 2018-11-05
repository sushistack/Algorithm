import java.io.*;

public class KBL1_2016years {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        bw.write(s.solution(5, 24));
        bw.flush();bw.close();
    }

    private static class Solution {
        private int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public String solution(int a, int b) {
            int day = 6;
            for (int i = 0; i < a - 1; i++) {
                day += months[i];
            }
            day += b;
            int remain = day % 7;

            switch (remain) {
                case 0 : return "FRI";
                case 1 : return "SAT";
                case 2 : return "SUN";
                case 3 : return "MON";
                case 4 : return "TUE";
                case 5 : return "WED";
                case 6 : return "THU";
                default: return null;
            }
        }
    }

}
