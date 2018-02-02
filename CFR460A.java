import java.io.*;

public class CFR460A {
    static int n, m, a, b;
    static String ins[];
    static double min = Double.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            a = Integer.parseInt(ins[0]);
            b = Integer.parseInt(ins[1]);
            double p = (double) b / (double)a;
            min = Math.min(min, (double)m / p);
        }
        bw.write(min + "\n");
        bw.flush();bw.close();
    }
}
