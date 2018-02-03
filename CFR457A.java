import java.io.*;

public class CFR457A {
    static int n, h, m, ans = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        h = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        if (ins[0].charAt(0) != '7' && ins[0].charAt(1) != '7'
        && ins[1].charAt(0) != '7' && ins[1].charAt(1) != '7') {

            while (true) {
                m -= n;ans++;
                if (m < 0) {
                    m += 60;h--;
                }
                if (h < 0) h += 24;
                String sh = h + "", mh = m + "";
                boolean isSeven = false;
                for (int i = 0; i < sh.length(); i++) {
                    if (sh.charAt(i) == '7') isSeven = true;
                }
                for (int i = 0; i < mh.length(); i++) {
                    if (mh.charAt(i) == '7') isSeven = true;
                }
                if (isSeven) break;
            }

        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
