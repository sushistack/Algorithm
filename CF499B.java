import java.io.*;
import java.util.HashMap;

public class CF499B {
    static int n, m;
    static boolean c[] = new boolean[3001];
    static HashMap<String, Integer> hm = new HashMap<>();
    static String[] ins, a = new String[3001], b = new String[3001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            a[i] = ins[0];b[i] = ins[1];
            hm.put(a[i], i);
            c[i] = (a[i].length() <= b[i].length());
        }
        ins = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ins.length; i++) {
            sb.append((c[hm.get(ins[i])]) ? a[hm.get(ins[i])] : b[hm.get(ins[i])]);
            if (i < ins.length - 1) sb.append(" ");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }
}
