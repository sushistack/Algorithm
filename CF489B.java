import java.io.*;
import java.util.Arrays;

public class CF489B {
    static int n, m, a[], b[];
    static int dp[] = new int[101], ans = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(ins[i - 1]);
        }
        Arrays.sort(a, 1, n + 1);
        m = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        b = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            b[i] = Integer.parseInt(ins[i - 1]);
        }
        Arrays.sort(b, 1, m + 1);

        ans = (n < m) ? match(a, b) : match(b, a);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    public static int match(int[] a, int[] b) {
        int count = 0;
        boolean[] checked = new boolean[b.length];
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (!checked[j] && Math.abs(a[i] - b[j]) < 2) {
                    count++;checked[j] = true;break;
                }
            }
        }
        return count;
    }





}
