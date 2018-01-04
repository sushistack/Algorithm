import java.io.*;

public class CF24E {
    static int n, x, v;
    static String[] ins;
    static Particle[] p = new Particle[500001];
    static double left, right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            x = Integer.parseInt(ins[0]);
            v = Integer.parseInt(ins[1]);
            p[i] = new Particle(x, v);
        }
        left = 0.;right = 10e18;

        for (int i = 0; i < 200; i++) {
            double mid = (left + right) / 2.0;
            double max = Double.NEGATIVE_INFINITY;
            boolean isPossible = false;
            for (int j = 0; !isPossible && j < n; j++) {
                if (p[j].v >= 0) {
                    max = Math.max(max, p[j].x + p[j].v * mid);
                }else {
                    if (p[j].x + p[j].v * mid < max) {
                        isPossible = true;
                        right = mid;
                    }
                }
            }
            if (!isPossible) {
                if (i == 0) {
                    bw.write("-1\n");
                    bw.flush();bw.close();return;
                }
                left = mid;
            }
        }
        bw.write(left + "\n");
        bw.flush();bw.close();
    }

    private static class Particle {
        int x, v;
        Particle(int x, int v) {
            this.x = x; this.v = v;
        }
    }
}
