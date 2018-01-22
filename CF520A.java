import java.io.*;

public class CF520A {
    static int n;
    static String in;
    static int a[] = new int[26];
    static boolean isAll = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        in = br.readLine().toLowerCase();
        for (int i = 0; i < n; i++) {
            a[in.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] == 0) {
                isAll  = false;break;
            }
        }
        bw.write(isAll ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
