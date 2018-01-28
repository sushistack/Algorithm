import java.io.*;

public class CF707A {
    static int n, m;
    static char a;
    static String ins[], in;
    static boolean isColor = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            in = br.readLine().replace(" ", "");
            for (int j = 0; j < m; j++) {
                a = in.charAt(j);
                if (a == 'Y' || a == 'C' || a == 'M') {
                    isColor = true; break;
                }
            }
        }
        bw.write(isColor ? "#Color\n" : "#Black&White\n");
        bw.flush();bw.close();
    }
}
