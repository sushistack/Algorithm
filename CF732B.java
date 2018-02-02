import java.io.*;

public class CF732B {
    static int n, k, a[] = new int[501], count = 0;
    static String ins[];
    static int[] dp = new int[501];
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(ins[i - 1]);
        }
        for (int i = 1; i < n; i++) {
            int t = k - (a[i] + a[i + 1]);
            if (t > 0) {
                a[i + 1] += t;count += t;
            }
        }
        StringBuffer sb = new StringBuffer(count + "\n");
        for (int i = 1; i <= n; i++) {
            sb.append(a[i]);
            if (i < n) sb.append(" ");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();

    }

}
