import java.io.*;
import java.util.Arrays;

public class CF451B {
    static int n, a[] = new int[100001], b[] = new int[100001], si, ei;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String ins[] = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(ins[i - 1]);
        }
        System.arraycopy(a, 0, b, 0, n + 1);
        Arrays.sort(a, 1, n + 1);si = 1;ei = n;
        boolean s = false, e = false, is;
        for (int i = 1; i < n; i++) {
            if (!s && b[i] >= b[i + 1]) {
                s = true;si = i;
            }
            if (s && b[i] < b[i + 1]) {
                e = true;ei = i;break;
            }
        }
        if (s) {
            for (int i = si; i <= ((si + ei) >> 1); i++) {
                int tmp = b[i];
                b[i] = b[(si + ei) - i];
                b[(si + ei) - i] = tmp;
            }
        }else ei = si;
        boolean sorted = true;
        for (int i = 1; i <= n; i++) {
            if (a[i] != b[i]) {
                sorted = false;break;
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append((sorted) ? "yes\n" : "no\n");
        sb.append((sorted) ? si + " " + ei + "\n" : "");
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

}
