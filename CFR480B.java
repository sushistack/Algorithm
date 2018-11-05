import java.io.*;
import java.util.Arrays;

public class CFR480B {
    static int n, k;
    static char[][] map = new char[4][100];
    static String ins[], ans = "NO\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        for (int i = 0; i < 4; i++) Arrays.fill(map[i], '.');
        if (k % 2 == 0) {
            ans = "YES\n";
            fillMap();
        } else {
            k--;
            fillMap();
            int mid = (n >> 1);
            for (int i = 1; i < 3; i++) {
                if (map[i][mid] == '.') {
                    map[i][mid] = '#';
                    ans = "YES\n"; break;
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        bw.write(ans);
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
    private static void fillMap() {
        for (int i = 1; i < (n >> 1) && k > 0; i++) {
            map[1][i] = map[2][n - i - 1] = '#';
            k-= 2;
        }
        for (int i = 1; i < (n >> 1) && k > 0; i++) {
            map[2][i] = map[1][n - i - 1] = '#';
            k-= 2;
        }
    }
}
