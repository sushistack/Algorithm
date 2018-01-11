import java.io.*;

public class CF546A {
    static int k, n, w;
    static long ans = 0;
    static String ins[];
    static long[] a = new long[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        k = Integer.parseInt(ins[0]);init();
        n = Integer.parseInt(ins[1]);
        w = Integer.parseInt(ins[2]);
        if (a[w] > n) ans = a[w] - n;
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    public static void init() {
        a[1] = k;
        for (int i = 2; i < 1001; i++) {
            a[i] = i * k + a[i - 1];
        }
    }

}
