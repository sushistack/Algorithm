import java.io.*;
import java.util.Arrays;

public class CF611C {
    static int h, w, q, r1, r2, c1, c2;
    static char[][] map = new char[501][501];
    static int[][][] m = new int[2][501][501];
    static String ins[], in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        h = Integer.parseInt(ins[0]);
        w = Integer.parseInt(ins[1]);
        for (int i = 1; i <= h; i++) {
            in = br.readLine();
            for (int j = 1; j <= w; j++) {
                map[i][j] = in.charAt(j - 1);
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= h; j++) {
                Arrays.fill(m[i][j], -1);
            }
        }
        for (int i = 1; i <= h; i++) {
            dpc(i, w);
        }
        for (int i = 1; i <= w; i++) {
            dpr(h, i);
        }


        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            ins = br.readLine().split(" ");
            r1 = Integer.parseInt(ins[0]);c1 = Integer.parseInt(ins[1]);
            r2 = Integer.parseInt(ins[2]);c2 = Integer.parseInt(ins[3]);
            bw.write(sum(r1, c1, r2, c2) + "\n");bw.flush();
        }
        bw.close();
    }
    public static int dpc(int r, int c) {
        if (c == 1) return 0;
        else if (m[0][r][c] != -1) return m[0][r][c];
        else {
            m[0][r][c] = 0;
            m[0][r][c] += dpc(r, c - 1) +
                    ((map[r][c - 1] == '.' && map[r][c] == '.') ? 1 : 0);

            return m[0][r][c];
        }
    }
    public static int dpr(int r, int c) {
        if (r == 1) return 0;
        else if (m[1][r][c] != -1) return m[1][r][c];
        else {
            m[1][r][c] = 0;

            m[1][r][c] += dpr(r - 1, c) +
                    ((map[r - 1][c] == '.' && map[r][c] == '.') ? 1 : 0);

            return m[1][r][c];
        }
    }
    public static int sum(int r1, int c1, int r2, int c2) {
        int s1 = 0, s2 = 0;
        for (int i = r1; i <= r2; i++) {
            int c2sum = m[0][i][c2] < 0 ? 0 : m[0][i][c2];
            int c1sum = m[0][i][c1] < 0 ? 0 : m[0][i][c1];
            s1 += c2sum - c1sum;
        }
        for (int i = c1; i <= c2; i++) {
            int r2sum = m[1][r2][i] < 0 ? 0 : m[1][r2][i];
            int r1sum = m[1][r1][i] < 0 ? 0 : m[1][r1][i];
            s2 += r2sum - r1sum;
        }
        return s1 + s2;
    }
}
