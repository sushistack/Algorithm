import java.io.*;
import java.util.Arrays;

public class B1976 {
    static int n, m, p[] = new int[201];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        Arrays.fill(p, -1);
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (ins[j].equals("1")) union(i, j);
            }
        }
        ins = br.readLine().split(" ");
        boolean flag = true;
        int root = find(Integer.parseInt(ins[0]) - 1);
        for (int i = 1; i < m; i++) {
            if (root != find(Integer.parseInt(ins[i]) - 1)) {
                flag = false;break;
            }
        }
        bw.write((flag ? "YES\n" : "NO\n"));
        bw.flush();bw.close();
    }

    public static int find(int n) {
        if (p[n] < 0) return n;
        p[n] = find(p[n]);
        return p[n];
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        p[b] = a;
    }
}
