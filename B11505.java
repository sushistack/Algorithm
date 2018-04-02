import java.io.*;
import java.util.Arrays;

public class B11505 {
    final static int MOD = 1000000007;
    static int n, m, k, size;
    static long a[] = new long[1000001], st[] = new long[1 << 21];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        k = Integer.parseInt(ins[2]);
        Arrays.fill(st, -1);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        init(a, st, 1, 0, n - 1);
        m += k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            long l = Long.parseLong(ins[1]);
            long r = Long.parseLong(ins[2]);
            if (ins[0].equals("1")) {
                a[(int)l - 1] = r;
                update(st, 1, 0, n - 1, (int)l - 1, r);
            }else {
                sb.append(mul(st, 1, 0, n - 1, (int)l - 1, (int)r - 1));
                sb.append("\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();bw.close();

    }

    public static long init(long a[], long t[], int node, int s, int e) {
        if (s == e) return t[node] = a[s];
        t[node] = init(a, t, node << 1, s, (s + e) >> 1);
        t[node] *= init(a, t, (node << 1) + 1, ((s + e) >> 1) + 1, e);
        return t[node] %= MOD;
    }

    public static long mul(long t[], int node, int s, int e, int l, int r) {
        if (l > e || r < s) return 1;
        if (l <= s && r >= e) return t[node];
        long ans = mul(t, node << 1, s, (s + e) >> 1, l, r) *
                mul(t, (node << 1) + 1, ((s + e) >> 1) + 1, e, l, r);
        return ans %= MOD;
    }

    public static long update(long t[], int node, int s, int e, int i, long newMul) {
        if (s == e) return t[node] = newMul;
        if (!(i < s || i > e)) {
            t[node] = update(t,node << 1, s, (s + e) >> 1, i, newMul) *
            update(t,(node << 1) + 1, ((s + e) >> 1) + 1, e, i, newMul);
            return t[node] %= MOD;
        }
        return 1;
    }
}
