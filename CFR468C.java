import java.io.*;
import java.util.StringTokenizer;

public class CFR468C {
    static int n, x[] = new int[100001], v = 0, kMin = (int)10e5 + 1, kMax;
    static int b[] = new int[200010];
    static String ins[];
    static double kAve = 0.;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        kMax = kMin * -1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            x[v] = Integer.parseInt(st.nextToken());
            b[x[v] + 100000]++;
            kMax = Math.max(kMax, x[v]);
            kMin = Math.min(kMin, x[v++]);
        }
        int count = 0;
        for (int i = kMin + 100000; i < kMax + 100001; i++) {
            if (b[i] != 0) count++;
        }
        StringBuilder sb = new StringBuilder();
        if (count == 1) {
            sb.append(n);sb.append("\n");
            for (int i = 0; i < n; i++) {
                sb.append(x[i]);
                if (i < n - 1) sb.append(" ");
            }
        }else if (count == 2) {
            if (b[kMin + 100001] == 0) {
                int dif = Math.min(b[kMin + 100000], b[kMin + 100002]);
                b[kMin + 100000] -= dif;
                b[kMin + 100001] += (dif << 1);
                b[kMin + 100002] -= dif;
                sb.append(n - (dif << 1));sb.append("\n");
                for (int i = 0; i < b[kMin + 100000]; i++) {
                    sb.append(kMin);sb.append(" ");
                }
                for (int i = 0; i < b[kMin + 100001]; i++) {
                    sb.append(kMin + 1);sb.append(" ");
                }
                for (int i = 0; i < b[kMin + 100002]; i++) {
                    sb.append(kMin  +2);sb.append(" ");
                }
            }else {
                sb.append(n);sb.append("\n");
                for (int i = 0; i < n; i++) {
                    sb.append(x[i]);
                    if (i < n - 1) sb.append(" ");
                }
            }
        } else {
            int dif = Math.min(b[kMin + 100000], b[kMin + 100002]);
            int t = (b[kMin + 100001] >> 1);
            if (dif < t) {
                b[kMin + 100000] += t;
                b[kMin + 100001] -= (t << 1);
                b[kMin + 100002] += t;
                sb.append(n - (t << 1));sb.append("\n");
            }else {
                b[kMin + 100000] -= dif;
                b[kMin + 100001] += (dif << 1);
                b[kMin + 100002] -= dif;
                sb.append(n - (dif << 1));sb.append("\n");
            }

            for (int i = 0; i < b[kMin + 100000]; i++) {
                sb.append(kMin);sb.append(" ");
            }
            for (int i = 0; i < b[kMin + 100001]; i++) {
                sb.append(kMin + 1);sb.append(" ");
            }
            for (int i = 0; i < b[kMin + 100002]; i++) {
                sb.append(kMin  +2);sb.append(" ");
            }

        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
