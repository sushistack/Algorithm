import java.io.*;

public class SWE1946 {
    static int t, T, n, k;
    static String ins[], c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = t = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            n = Integer.parseInt(br.readLine());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                ins = br.readLine().split(" ");
                c = ins[0]; k = Integer.parseInt(ins[1]);
                for (int j = 0; j < k; j++)  sb.append(c);

            }
            StringBuffer ans = new StringBuffer();
            for (int i = 0; i < sb.length(); i += 10) {
                ans.append(sb.substring(i, (i + 10 <= sb.length()) ? i + 10 : sb.length()) + "\n");
            }
            bw.write("#" + (t - T) + "\n" + ans.toString());bw.flush();
        }
        bw.close();
    }
}
