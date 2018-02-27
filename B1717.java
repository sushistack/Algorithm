import java.io.*;
import java.util.Arrays;

public class B1717 {
    static int n, m, a, b, p[] = new int[1000001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        Arrays.fill(p, -1);
        StringBuilder sb = new StringBuilder();
        while (m-- != 0) {
            ins = br.readLine().split(" ");
            a = Integer.parseInt(ins[1]);
            b = Integer.parseInt(ins[2]);
            if (ins[0].equals("0")) union(a, b);
            else {
                int pa = find(a), pb = find(b);
                sb.append(((pa != -1 && pb != -1 && (pa == pb)) ? "YES\n" : "NO\n"));
            }
        }
        bw.write(sb.toString());
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
