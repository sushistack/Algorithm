import java.io.*;
import java.util.Arrays;

public class CF509A {
    static int n, ans = 0;
    static String ins[];
    static int[][] map = new int[11][11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Arrays.fill(map[1], 1);
        for (int i = 2; i <= n; i++) {
            map[i][1] = 1;
            for (int j = 2; j <= n; j++) {
                map[i][j] = map[i][j - 1] + map[i - 1][j];
            }
        }
        bw.write(map[n][n] + "\n");
        bw.flush();bw.close();
    }
}
