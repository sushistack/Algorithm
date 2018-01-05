import java.io.*;

public class B9252 {
    static String s1, s2;
    static int[][] lcs = new int[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s1 = br.readLine();s2 = br.readLine();
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
        String ans = lcs[s1.length()][s2.length()] + "\n";
        StringBuffer sb = new StringBuffer();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;j--;
            } else {
                if (lcs[i][j] == lcs[i - 1][j]) i--;
                else j--;
            }
        }
        ans += sb.reverse().toString() + "\n";
        bw.write(ans);
        bw.flush();bw.close();
    }
}
