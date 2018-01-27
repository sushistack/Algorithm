import java.io.*;
import java.util.Arrays;

public class CF432A {
    static int n, k, count = 0;
    static int[] y = new int[2001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            y[i] = Integer.parseInt(ins[i - 1]);
        }
        Arrays.sort(y, 1, n + 1);
        for (int i = 1; i <= n; i++) {
            count += (y[i] <= 5 - k) ? 1 : 0;
        }
        bw.write(count / 3 + "\n");
        bw.flush();bw.close();
    }
}
