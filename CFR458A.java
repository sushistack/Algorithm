import java.io.*;

public class CFR458A {
    static int n, max = Integer.MIN_VALUE;
    static int[] a = new int[1001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ins[i]);
            if (a[i] >= 0) {
                if (Math.sqrt(a[i]) - (int) Math.sqrt(a[i]) > 10e-9) {
                    max = Math.max(max, a[i]);
                }
            }else {
                max = Math.max(max, a[i]);
            }
        }
        bw.write(max + "\n");
        bw.flush();bw.close();
    }
}
