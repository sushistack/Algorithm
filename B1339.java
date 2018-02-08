import java.io.*;
import java.util.Arrays;

public class B1339 {
    static int n, a[] = new int[26], ans = 0, m = 9;
    static char[][] c = new char[10][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            c[i] = br.readLine().toCharArray();
            for (int j = 0; j < c[i].length; j++) {
                a[c[i][j] - 65] += (int)Math.pow(10, (c[i].length - 1 - j));
            }
        }
        Arrays.parallelSort(a);
        for (int i = 25; i > -1 ; i--) {
            if (a[i] == 0) break;
            ans += a[i] * m--;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }



}
