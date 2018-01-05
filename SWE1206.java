import java.io.*;

public class SWE1206 {
    static int t = 10, n;
    static int[] a = new int[1005];
    static String[] ins;
    static int[] dy = {-2, -1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t -- != 0) {
            n = Integer.parseInt(br.readLine());
            ins = br.readLine().split(" ");
            for (int i = 2; i < ins.length + 2; i++) {
                a[i] = Integer.parseInt(ins[i - 2]);
            }
            long ans = 0;
            for (int i = 2; i < n; i++) {
                int max = 0;
                for (int j = 0; j < 4; j++) {
                    int ni = i + dy[j];
                    max = Math.max(max, a[ni]);
                }
                ans += (a[i] > max) ? a[i] - max : 0;
            }
            bw.write("#" + (10 - t) + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }
}
