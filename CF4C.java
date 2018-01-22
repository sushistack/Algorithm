import java.io.*;
import java.util.HashMap;

public class CF4C {
    static int n;
    static String in;
    static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            in = br.readLine();
            if (hm.containsKey(in)) {
                sb.append(in + hm.get(in) + "\n");
                hm.put(in, hm.get(in) + 1);
            }else {
                hm.put(in, 1);sb.append("OK\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
