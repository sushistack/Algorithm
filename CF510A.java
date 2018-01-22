import java.io.*;
import java.util.Arrays;

public class CF510A {
    static int n, m;
    static char[][] map = new char[51][51];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) Arrays.fill(map[i], '#');
            else {
                Arrays.fill(map[i], '.');
                if ((i - 1) % 4 == 0) map[i][m - 1] = '#';
                else map[i][0] = '#';
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(String.valueOf(map[i],0, m) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
