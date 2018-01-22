import java.io.*;

public class CF141A {
    static String ins[] = new String[3];
    static boolean is = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 3; i++) ins[i] = br.readLine();
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < ins[i].length(); k++) {
                String s = ins[i].charAt(k) + "";
                int pre = ins[2].length();
                ins[2] = ins[2].replaceFirst(s, "");
                int nex = ins[2].length();
                if (pre == nex) {is = false; break;}
            }
            if (!is) break;
        }
        bw.write((ins[2].length() == 0) ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
