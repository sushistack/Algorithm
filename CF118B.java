import java.io.*;
import java.util.ArrayList;

public class CF118B {
    static int n, a[][] = new int[20][20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                a[i][j] = (i + j) - (n);
            }
        }

        ArrayList<String> s = new ArrayList<>();
        StringBuffer t = new StringBuffer();
        for (int i = 0; i <= n; i++) {
            t.setLength(0);
            for (int j = 0; j <= n; j++) {
                t.append(a[i][j] < 0 ? " " : a[i][j]);t.append(" ");
            }
            String tt = t.toString() + t.reverse().substring(3, t.length()) + "\n";
            s.add(tt.substring(0, tt.lastIndexOf("0") + 1));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.size(); i++) sb.append(s.get(i) + "\n");
        for (int i = s.size() - 2; i > -1; i--) sb.append(s.get(i) + "\n");

        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
