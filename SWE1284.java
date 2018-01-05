import java.io.*;

public class SWE1284 {
    static int t, p, q, r, s, w, ans, a ,b;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            ins = br.readLine().split(" ");
            p = Integer.parseInt(ins[0]);q = Integer.parseInt(ins[1]);
            r = Integer.parseInt(ins[2]);s = Integer.parseInt(ins[3]);
            w = Integer.parseInt(ins[4]);
            a = w * p;b = (w > r) ?  q + (w - r) * s : q;
            bw.write("#" + i + " " + Math.min(a, b) + "\n");bw.flush();
        }
        bw.close();
    }
}
