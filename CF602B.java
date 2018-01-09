import java.io.*;

public class CF602B {
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
        int max = 2, count = 0, i = 1;
        while (i < n - 1) {
            count = 1;
            int diff = a[i + 1] - a[i];
            while (diff == 0) { i++; count++; diff = a[i + 1] - a[i]; }
            if (i == n) {max = Math.max(max, count); break;}
            count++;
            int m1, m2, idx1, idx2;
            if (a[i] < a[i + 1]) {
                m1 = a[i + 1];m2 = a[i];
                idx1 = i + 1;idx2 = i;
            }else {
                m1 = a[i];m2 = a[i + 1];
                idx1 = i;idx2 = i + 1;
            }
            for (int j = i + 2; j <= n; j++) {
                if (j == n) i = n;
                if (a[j] == m1 || a[j] == m2) count++;
                else {
                    if (a[j] > m1) i = idx2 + 1;
                    else i = idx1 + 1;
                    break;
                }
            }
            max = Math.max(max, count);
        }

        bw.write(max + "\n");
        bw.flush();bw.close();
    }

}
