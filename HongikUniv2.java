import java.io.*;

public class HongikUniv2 {
    static int a[] = new int[1001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double m = Double.parseDouble(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < ins.length; i++) {
            double t = Double.parseDouble(ins[i]) * m;
            int in = (int)(t + 1);
            if ((double)in - t < 10e-7) t = in;
            a[(int)t]++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            sb.append(a[i]);
            if (i < m - 1) sb.append(" ");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }
}
