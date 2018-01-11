import java.io.*;
import java.util.Arrays;

public class CF160A {
    static int n, a[] = new int[101], prefix[] = new int[101], ans;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(ins[i - 1]);
        }
        Arrays.sort(a, 1, n + 1);
        for (int i = 1; i <= n; i++) {
            prefix[i] = (i == 1) ? a[i] : prefix[i - 1] + a[i];
        }
        for (int i = n; i > -1; i--) {
            int m = prefix[n] - prefix[i];
            int t = prefix[i];
            if (m > t){ ans = n - i;break;}
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
