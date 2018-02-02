import java.io.*;
import java.util.HashMap;

public class CF466C {
    static int n, a[] = new int[500001];
    static long l, m, r, count = 0, s;
    static String ins[];
    static HashMap<Long, Long> set = new HashMap<Long, Long>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(ins[i - 1]);
            s += a[i];
        }
        if (s % 3 == 0) {
            long l = s / 3, r = l << 1, sum = 0, t = 0;
            for (int i = 1; i < n; i++) {
                sum += a[i];
                if (sum == r) count += t;
                if (sum == l) t++;
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
