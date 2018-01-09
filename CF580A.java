import java.io.*;

public class CF580A {
    static int n;
    static int[] a = new int[100002];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(ins[i - 1]);
        }
        int max = 1, i = 1, count, cur = a[1];
        while (i != n) {
            count = 1;
            for (int j = i + 1; j <= n; j++) {
                if (j == n) i = n;
                if (cur > a[j]) { i = j; cur = a[j];break; }
                else {cur = a[j];count++;}
            }
            max = Math.max(max, count);
        }
        bw.write(max + "\n");bw.flush();
        bw.close();
    }
}
