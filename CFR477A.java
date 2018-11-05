import java.io.*;

public class CFR477A {
    static int n, s, h[] = new int[101], m[] = new int[101], t[] = new int[101], ans = -1;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        s = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            h[i] = Integer.parseInt(ins[0]);
            m[i] = Integer.parseInt(ins[1]);
            t[i] = timeToMin(h[i], m[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (t[i + 1] - t[i] >= (s << 1) + 2) {
                ans = t[i] + s + 1;break;
            }
        }
        ans = (ans == -1) ? t[n - 1] + s + 1 : ans;
        ans = (t[0] > s) ? 0 : ans;
        bw.write(minToTime(ans));
        bw.flush();bw.close();
    }
    private static String minToTime(int m) {
        return (m / 60) + " " + (m % 60) + "\n";
    }

    private static int timeToMin(int h, int m) {
        return h * 60 + m;
    }
}
