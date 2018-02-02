import java.io.*;
import java.util.ArrayList;

public class CFR460B {
    static int n;
    static ArrayList<Long> l = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        initPerfect();
        bw.write(l.get(n - 1) + "\n");
        bw.flush();bw.close();
    }

    public static void initPerfect() {
        String t = null;
        for (long i = 19; l.size() < 10001; i+=9) {
            if (i % 10 == 0) {
                t = i + "";
                int ans = 0;
                for (int j = 0; j < t.length(); j++) {
                   ans += t.charAt(j) - 48;
                }
                if (ans == 10) l.add(i);

                if (ans == 1) {

                }else {
                    String q = (t.charAt(0) - 47) + "";
                    for (int j = 0; j < t.length() - 2; j++) q += "0";
                    int z = 10 - (t.charAt(0) - 47);
                    q += (z == 0) ? 9 : z;
                    i = Long.parseLong(q);
                }

                l.add(i);
            }else l.add(i);
        }
    }
}
