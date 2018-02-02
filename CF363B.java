import java.io.*;

public class CF363B {
    static int n, k, h[] = new int[150001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(ins[i - 1]);
        }
        int min, cur = 0, ans = 1;
        for (int i = 1; i <= k; i++) cur += h[i];
        min = cur;
        for (int i = 2; i <= n - (k - 1); i++) {
            cur += (h[i + k - 1] - h[i - 1]);
            if (min > cur) {
                ans = i;min = cur;
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
