import java.io.*;

public class B2042 {
    static int n, m, k;
    static String ins[];
    static long st[] = new long[(1 << 21)], a[] = new long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        k = Integer.parseInt(ins[2]);
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }
        init(a, st, 1, 0, n - 1);
        m += k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            long l = Long.parseLong(ins[1]);
            long r = Long.parseLong(ins[2]);
            if (ins[0].equals("1")) {
                l--;
                long d = r - a[(int)l];
                a[(int)l] = r;
                update(st, 1, 0, n - 1, (int)l, d);
            }else {
                sb.append(sum(st, 1, 0, n - 1, (int)l - 1, (int)r - 1));
                sb.append("\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }


    public static long init(long a[], long t[], int node, int s, int e) {
        if (s == e) return t[node] = a[s];
        return t[node] = init(a, t, node << 1, s, (s + e) >> 1) +
                init(a, t, (node << 1) + 1, ((s + e) >> 1) + 1, e);
    }

    public static long sum(long t[], int node, int s, int e, int l, int r) {
        if (l > e || r < s) return 0;
        if (l <= s && r >= e) return t[node];
        return sum(t, node << 1, s, (s + e) >> 1, l, r) +
                sum(t, (node << 1) + 1, ((s + e) >> 1) + 1, e, l, r);
    }

    public static void update(long t[], int node, int s, int e, int i, long d) {
        if (i < s || i > e) return;
        t[node] = t[node] + d;
        if (s != e) {
            update(t,node << 1, s, (s + e) >> 1, i, d);
            update(t,(node << 1) + 1, ((s + e) >> 1) + 1, e, i, d);
        }
    }
}
