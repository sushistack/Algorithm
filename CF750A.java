import java.io.*;

public class CF750A {
    static int n, k, t, ans;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        ans = n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        for (int i = 0; i <= n; i++) {
            t = 5 * ((i * (i + 1)) >> 1);
            t = 240 - t;
            if (t < k) {
                ans = i - 1;break;
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
