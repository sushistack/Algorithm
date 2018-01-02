import java.io.*;

public class CF14A {
    static int n, m, nx = 51, xx = -1, ny = 51, xy = -1;
    static String ins[], in;
    static char[][] table = new char[51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            in = br.readLine();
            for (int j = 0; j < m; j++) {
                table[i][j] = in.charAt(j);
                if (table[i][j] == '*' && xy < j) xy = j;
            }
            for (int j = m - 1; j > -1; j--) {
                if (table[i][j] == '*' && ny > j) ny = j;
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (table[i][j] == '*' && xx < i) xx = i;
            }
            for (int i = n - 1; i > -1; i--) {
                if (table[i][j] == '*' && nx > i) nx = i;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = nx; i <= xx; i++) {
            for (int j = ny; j <= xy; j++) {
                sb.append(table[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
