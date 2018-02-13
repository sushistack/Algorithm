import java.io.*;

public class B2104 {
    static int n;
    static long a[] = new long[100001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(ins[i - 1]);
        }
        bw.write(dac(1, n) + "\n");
        bw.flush();bw.close();
    }

    public static long dac(int s, int e) {
        if (s == e) return a[s] * a[s];
        int mid = (s + e) >> 1;
        long ans = Math.max(dac(s, mid), dac(mid + 1, e)), min = a[mid];
        int l, r;
        long sum = a[mid];
        l = r = mid;
        while (r - l < e - s) {
            long p, q;
            p = (l > s) ? (a[l - 1] + sum) * Math.min(min, a[l - 1]) : -1;
            q = (r < e) ? (a[r + 1] + sum) * Math.min(min, a[r + 1]) : -1;
            if (p > q) {
                sum += a[l - 1];
                min = Math.min(min, a[l - 1]);
                l--;
            }else {
                sum += a[r + 1];
                min = Math.min(min, a[r + 1]);
                r++;
            }
            ans = Math.max(ans, sum * min);
        }
        return ans;
    }
}
