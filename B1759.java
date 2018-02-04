import java.io.*;
import java.util.Arrays;

public class B1759 {
    static int l,c;
    static String ins[];
    static boolean isVow[] = new boolean[26];
    static StringBuffer sb = new StringBuffer();
    static char[] ans = new char[16];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        l = Integer.parseInt(ins[0]);
        c = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        Arrays.sort(ins);
        isVow[0] = isVow[4] = isVow[8] = isVow[14] = isVow[20] = true;
        dfs(0, -1,0, 0);

        bw.write(sb.toString());
        bw.flush();bw.close();

    }

    public static void dfs(int idx, int prev, int con, int vow) {

        if (idx == l) {
            if (con > 1 && vow > 0) {
                sb.append(new String(ans, 0, l));sb.append("\n");
            }
            return;
        }

        for (int i = prev  + 1; i < c; i++) {
            int c = (isVow[ins[i].charAt(0) - 97]) ? 0 : 1;
            int v = (isVow[ins[i].charAt(0) - 97]) ? 1 : 0;
            ans[idx] = ins[i].charAt(0);
            dfs(idx + 1, i, con + c, vow + v);

        }



    }
}
