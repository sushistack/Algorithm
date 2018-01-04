import java.io.*;

public class CF200B {
    static int n;
    static int[] p = new int[101];
    static String[] ins;
    static double s = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(ins[i]);
            s += p[i] / 100.;
        }
        double ans = (s * 100) / (double)n;
        bw.write(ans + "\n");
        bw.flush();bw.close();

    }
}
