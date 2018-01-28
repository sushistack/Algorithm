import java.io.*;
import java.util.HashMap;

public class CF270A {
    static int t, a;
    static HashMap<Integer, Boolean> degrees = new HashMap<>();
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            a = Integer.parseInt(br.readLine());
            sb.append(isRegularPolygon(a) ? "YES\n" : "NO\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static boolean isRegularPolygon(int a) {
        if (a < 60) return false;
        return ((360. / (180. - (double) a)) == (int)(360. / (180. - (double) a)));
    }
}
