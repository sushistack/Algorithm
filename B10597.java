import java.io.*;
import java.util.Arrays;

public class B10597 {
    static String in;
    static StringBuffer sb = new StringBuffer();
    static boolean set = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();

        int[] b = new int[120];
        Arrays.fill(b, -1);
        boolean[] ch = new boolean[61];
        dfs(0, b, ch);

        bw.write(sb.toString().substring(0, sb.length() - 1) + "\n");
        bw.flush();bw.close();
    }

    public static void dfs(int pos, int[] b, boolean[] ch) {
        if (pos == in.length()) {
            int firstFalse = -1;
            for (int i = 1; i < 61; i++) {
                if (!ch[i]) {
                    firstFalse = i;break;
                }
            }
            boolean flag = true;
            for (int i = firstFalse + 1; i < 61; i++) {
                if (ch[i]) {
                    flag = false;break;
                }
            }
            if (flag) {
                for (int next = 0; b[next] != -1 ; next += b[next]) {
                    sb.append(in.substring(next, next + b[next]));
                    sb.append(" ");
                }
                set = true;
            }
            return;
        }
        int[] bb = new int[120], bbb = new int[120];
        boolean[] chh = new boolean[61], chhh = new boolean[61];
        System.arraycopy(b, 0, bb, 0, 120);
        System.arraycopy(b, 0, bbb, 0, 120);
        int t = in.charAt(pos) - 48;
        if (!ch[t]) {
            System.arraycopy(ch, 0 , chh, 0, 61);
            bb[pos] = 1;chh[t] = true;
            dfs(pos + 1, bb, chh);
            if (set) return;
        }

        if (pos < in.length() - 1 && in.charAt(pos) != '0' && in.charAt(pos) < '6') {
            int m = Integer.parseInt(in.substring(pos, pos + 2));
            if (!ch[m]) {
                System.arraycopy(ch, 0 , chhh, 0, 61);
                chhh[m] = true;bb[pos] = 2;
                if (set) return;
                dfs(pos + 2, bb, chhh);
            }
        }

    }


}
