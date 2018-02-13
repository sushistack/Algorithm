import java.io.*;

public class B1725 {
    static int n;
    static long a[] = new long[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }
        bw.write(dac(0, n) + "\n");
        bw.flush();bw.close();
    }

    public static long dac(int s, int e) {
        if (s == e) return 0;
        if (e - s == 1) return a[s];
        int mid = (s + e) >> 1, l, r, w = 1;
        long ans = Math.max(dac(s, mid), dac(mid, e)), h = a[mid];
        l = r = mid;
        while (r - l < e - s) {
            long p = (l > s) ? Math.min(h, a[l - 1]) : -1;
            long q = (r < e) ? Math.min(h, a[r + 1]) : -1;
            if (p > q) {
                h = p;l--;
            }else {
                h = q;r++;
            }
            ans = Math.max(ans, ++w * h);
        }
        return ans;
    }
}
