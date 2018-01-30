import java.io.*;

public class CF467B {
    static int n, m, k, p[] = new int[1001], f, ans = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        k = Integer.parseInt(ins[2]);
        for (int i = 0; i < m; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        f = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String t = Integer.toBinaryString(f ^ p[i]);
            t = t.replace("0", "");
            ans += (t.length() <= k) ? 1 : 0;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
