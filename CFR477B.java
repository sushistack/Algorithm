import java.io.*;
import java.util.Arrays;

public class CFR477B {
    static int n, a, b, s[] = new int[100001], sumHole = 0, cur = 0, ans = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        a = Integer.parseInt(ins[1]);
        b = Integer.parseInt(ins[2]);

        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(ins[i]);
            sumHole += s[i];
        }
        cur = (s[0] * a) / sumHole;
        Arrays.parallelSort(s, 1, n);
        int i = n - 1;
        while (cur < b && i > 0) {
            sumHole -= s[i--];
            cur = (s[0] * a) / (sumHole);
            ans++;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
