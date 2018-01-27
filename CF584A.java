import java.io.*;
import java.math.BigInteger;

public class CF584A {
    static int n, t;
    static String ins[];
    static BigInteger bi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        t = Integer.parseInt(ins[1]);
        StringBuffer sb = new StringBuffer("1");
        for (int i = 1; i < n; i++) sb.append("0");
        bi = new BigInteger(sb.toString());
        BigInteger remain = bi.subtract(bi.divide(new BigInteger(t + "")).multiply(new BigInteger(t + "")));
        BigInteger ans = bi.add(new BigInteger(t + "").subtract(remain));
        bw.write((ans.toString().length() != n) ? "-1\n" : ans.toString() + "\n");
        bw.flush();bw.close();
    }
}
