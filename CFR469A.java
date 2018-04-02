import java.io.*;

public class CFR469A {
    static int l, r, a, ans, t = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        l = Integer.parseInt(ins[0]);
        r = Integer.parseInt(ins[1]);
        a = Integer.parseInt(ins[2]);

        ans = (l > r) ? r : l;
        l -= ans;r -= ans;
        if (l > 0) t = (l > a) ? a : l;
        if (r > 0) t = (r > a) ? a : r;
        ans += t;a -= t;
        if (a > 1) ans += (a >> 1);

        bw.write((ans << 1) + "\n");
        bw.flush();bw.close();
    }
}
