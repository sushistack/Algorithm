import java.io.*;

public class CFR480A {
    static char[] c;
    static int l, p;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        c = br.readLine().toCharArray();
        for (int i = 0; i < c.length; i++) {
            l += (c[i] == 'o') ? 0 : 1;
            p += (c[i] == 'o') ? 1 : 0;
        }
        ans = (p == 0 || l == 0) ? "YES\n" : (l % p == 0) ? "YES\n" : "NO\n";
        bw.write(ans);
        bw.flush();bw.close();
    }
}
