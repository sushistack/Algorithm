import java.io.*;

public class CFR476C {
    static long n, k, m, d, ans = 0, t;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Long.parseLong(ins[0]);k = Long.parseLong(ins[1]);
        m = Long.parseLong(ins[2]);d = Long.parseLong(ins[3]);
        long x = n / (d * k);
        ans = (n / x) % k == 0 ? (x - 1) * (n / x) : x * (n / x);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
