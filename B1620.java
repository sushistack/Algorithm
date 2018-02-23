import java.io.*;
import java.util.TreeMap;

public class B1620 {
    static int n, q;
    static String ins[], in;
    static TreeMap<Integer, String> tm = new TreeMap<>();
    static TreeMap<String, Integer> tm2 = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        q = Integer.parseInt(ins[1]);
        for (int i = 1; i <= n; i++) {
            in = br.readLine();tm.put(i, in);
            tm2.put(in, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            in = br.readLine();
            if (isInteger(in)) sb.append(tm.get(Integer.parseInt(in)));
            else sb.append(tm2.get(in));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
