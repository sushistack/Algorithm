import java.io.*;

public class CFER37A {
    static int t, n, k, x[] = new int[201];
    static String ins[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            k = Integer.parseInt(ins[1]);
            ins = br.readLine().split(" ");
            for (int i = 1; i <= k; i++) {
                x[i] = Integer.parseInt(ins[i - 1]);
            }
            int max = 0;
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= k; j++) {
                    min = Math.min(min, Math.abs(i - x[j]) + 1);
                }
                max = Math.max(max, min);
            }
            bw.write(max + "\n");bw.flush();
        }
        bw.close();
    }
}
