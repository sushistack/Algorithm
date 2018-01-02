import java.io.*;

public class B2166 {
    static long[] x = new long[10001];
    static long[] y = new long[10001];
    static int n;
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            x[i] = Integer.parseInt(ins[0]);
            y[i] = Integer.parseInt(ins[1]);
        }

        String s = String.format("%.1f", getAreaOfPolygon());
        bw.write(s + "\n");
        bw.flush();bw.close();
    }

    public static double getAreaOfPolygon() {
        long area = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            area += (x[j] + x[i]) * (y[j] - y[i]);
            j = i;
        }
        return Math.abs(area) / 2.;
    }
}
