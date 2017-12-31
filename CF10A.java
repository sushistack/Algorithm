import java.io.*;

public class CF10A {
    static String[] ins;
    static int N, s, e;
    static long ans = 0;
    static int[] p = new int[3];
    static int[] t = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        N = Integer.parseInt(ins[0]);
        for (int i = 1; i < 6; i++) {
            if (i < 4) p[i - 1] = Integer.parseInt(ins[i]);
            else t[i - 4] = Integer.parseInt(ins[i]);
        }
        int pre = -1, term;
        for (int i = 0; i < N; i++) {
            ins = br.readLine().split(" ");
            s = Integer.parseInt(ins[0]);
            e = Integer.parseInt(ins[1]);
            if (pre < 0) pre = s;
            ans += (e - s) * p[0];
            term = s - pre;
            if (term > t[0] + t[1]) {
                ans += (term - (t[0] + t[1])) * p[2];
                term = t[0] + t[1];
            }
            if (term > t[0]) {
                ans += (term - t[0]) * p[1];
                term = t[0];
            }
            ans += term * p[0];
            pre = e;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
