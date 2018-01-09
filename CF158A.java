import java.io.*;

public class CF158A {
    static int n, k, ans = 0, m;
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);k = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        m = Integer.parseInt(ins[k - 1]);
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(ins[i]);
            ans += (t >= m && t > 0) ? 1 : 0;
        }
        bw.write(ans + "\n");bw.flush();
        bw.close();
    }
}
