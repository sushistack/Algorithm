import java.io.*;
import java.util.HashSet;

public class CFR461C {
    static long n, k;
    static String ins[];
    static boolean isM = true;
    static HashSet<Long> l = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        if (k < n) {
            initDivisors();
            if (!l.contains(k)) isM = false;
        }
        bw.write(isM ? "NO\n" : "YES\n");
        bw.flush();bw.close();
    }
    public static void initDivisors() {
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) l.add(i);
        }
    }
}
