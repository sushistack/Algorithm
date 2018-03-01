import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class B4195 {
    static int t, f, p[] = new int[100001], count;
    static HashMap<String, Integer> hm = new HashMap<>();
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- != 0) {
            hm.clear();count = 0;Arrays.fill(p, -1);
            f = Integer.parseInt(br.readLine());
            for (int i = 0; i < f; i++) {
                ins = br.readLine().split(" ");
                if (!hm.containsKey(ins[0])) hm.put(ins[0], count++);
                if (!hm.containsKey(ins[1])) hm.put(ins[1], count++);
                union(hm.get(ins[0]), hm.get(ins[1]));
                sb.append(-p[find(hm.get(ins[0]))]);sb.append("\n");
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
        a = find(a);b = find(b);
        if (a == b) return;
        p[a] += p[b];p[b] = a;
    }
}
