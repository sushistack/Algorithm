import java.io.*;

public class B1780 {
    static int n, a[][] = new int[2188][2188], p[] = new int[3];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(ins[j]);
            }
        }
        dac(0, 0, n, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(p[i]);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static void dac(int sx, int sy, int ex, int ey) {
        if (ex - sx == 1 && ey - sy == 1) {
            p[a[sx][sy] + 1]++;
            return;
        }
        boolean flag = true;
        int t = a[sx][sy];
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if (t != a[i][j]) {
                    flag = false; break;
                }
            }
            if (!flag) break;
        }
        if (flag) p[t + 1]++;
        else {
            int term = (ex - sx) / 3;
            for (int i = sx; i < ex; i+=term) {
                for (int j = sy; j < ey; j+=term) {
                    dac(i, j, i + term, j + term);
                }
            }
        }
    }
}
