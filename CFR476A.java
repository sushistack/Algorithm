import java.io.*;

public class CFR476A {
    static int k, n, s, p, ans, needSheets;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        k = Integer.parseInt(ins[0]);n = Integer.parseInt(ins[1]);
        s = Integer.parseInt(ins[2]);p = Integer.parseInt(ins[3]);
        needSheets = n / s;
        needSheets += (n % s == 0) ? 0 : 1;
        needSheets *= k;
        ans = needSheets / p;
        ans += (needSheets % p == 0) ? 0 : 1;
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
