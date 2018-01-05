import java.io.*;
import java.util.Arrays;

public class SWE1204 {
    static int t = 10 ,n;
    static long[] a = new long[101];
    static String ins[], s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            Arrays.fill(a, 0);
            ins = br.readLine().split(" ");
            for (int i = 0; i < ins.length; i++) {
                a[Integer.parseInt(ins[i])]++;
            }
            int maxIdx = -1;
            long max = -1;
            for (int i = 0; i < 101; i++) {
                if (max <= a[i]) {
                    max = a[i];maxIdx = i;
                }
            }
            bw.write("#" + n + " " + maxIdx + "\n");
            bw.flush();
        }
        bw.close();
    }
}
