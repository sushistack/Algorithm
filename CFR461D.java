import java.io.*;
import java.util.ArrayList;

public class CFR461D {
    static int n, max = 0;
    static String t[] = new String[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            t[i] = br.readLine();
        }
        ArrayList<Integer> l = new ArrayList<>();
        boolean[] b = new boolean[n + 1];
        dfs(0, l, b);
        bw.write(max + "\n");
        bw.flush();bw.close();
    }

    public static void dfs(int idx, ArrayList<Integer> l, boolean[] b) {
        if (idx == n) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < l.size(); i++) {
                sb.append(t[l.get(i)]);
            }
            String s = sb.toString();
            int count = 0;
            for (int i = 0;;) {
                int ts = s.indexOf('s', i);
                if (ts < 0) break;
                String x = s.substring(ts + 1, s.length()).replace("s", "");
                count += x.length();
                i = ts + 1;
            }
            max = Math.max(max, count);
        }

        ArrayList<Integer> nl = new ArrayList<>(l);
        boolean[] nb = new boolean[n + 1];
        System.arraycopy(b, 0, nb, 0, n + 1);
        for (int i = 1; i <= n; i++) {
            if (!nb[i]) {
                nl.add(i);
                nb[i] = true;dfs(idx + 1, nl, nb);
                nl.remove(nl.size() - 1);nb[i] = false;
            }
        }

    }
}
