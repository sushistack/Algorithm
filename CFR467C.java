import java.io.*;

public class CFR467C {
    static long k, d, t;
    static double ans = 0., cooked = 0.;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        k = Long.parseLong(ins[0]);
        d = Long.parseLong(ins[1]);
        t = Long.parseLong(ins[2]);
        if (k > 0 && k % d == 0) ans = (double) t;
        if (ans != (double)t) {
            double time = 0.;
            boolean isTurned = true;
            double kt = k, dt = d;

            while (1 - cooked > 10e-9) {
                cooked += 1 / (double)(t << 1);
                time += (isTurned) ? 0.5 : 1;
                kt -= (isTurned) ? 0.5 : 1;
                dt -= (isTurned) ? 0.5 : 1;
                if (kt - 0 < 10e-3) {
                    kt = k;isTurned = false;
                }
                if (dt - 0 < 10e-3) {
                    dt = d;
                    if (!isTurned)  {
                        isTurned = true;kt = k;
                    }
                }

            }
            ans = time;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
