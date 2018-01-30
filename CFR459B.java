import java.io.*;
import java.util.HashMap;

public class CFR459B {
    static int n, m;
    static String ins[];
    static HashMap<String, String> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            hm.put(ins[1], ins[0]);

        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            sb.append(ins[0] + " " + ins[1]);
            sb.append(" #" + hm.get(ins[1].substring(0, ins[1].length() - 1)) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

}
