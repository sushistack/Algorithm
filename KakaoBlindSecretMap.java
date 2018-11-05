import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KakaoBlindSecretMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution s = new Solution();
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        bw.write(s.solution(5, arr1, arr2) + "\n");
        bw.flush();
        bw.close();
    }

    private static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {

            int[][] a1 = new int[n][n];
            int[][] a2 = new int[n][n];

            for (int i = 0; i < arr1.length; i++) {
                String t = Integer.toBinaryString(arr1[i]);
                String t2 = Integer.toBinaryString(arr2[i]);
                if (t.length() < n) {
                    int d = n - t.length();
                    StringBuilder sb = new StringBuilder();
                    while (d-- != 0) sb.append("0");
                    t = sb.toString() + t;
                }

                if (t2.length() < n) {
                    int d = n - t2.length();
                    StringBuilder sb = new StringBuilder();
                    while (d-- != 0) sb.append("0");
                    t2 = sb.toString() + t2;
                }

                for (int j = 0; j < n; j++) {
                    a1[i][j] = t.charAt(j) - 48;
                    a2[i][j] = t2.charAt(j) - 48;
                }
            }

            int[][] a = new int[n][n];
            String[] answer = new String[n];
            StringBuilder sb;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a1[i][j] == 1 || a2[i][j] == 1) {
                        a[i][j] = 1;
                    }
                }
                sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                   sb.append((a[i][j] == 1 ? "#" : " "));
                }
                answer[i] = sb.toString();
            }
            return answer;
        }
    }
}