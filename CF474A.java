import java.io.*;

public class CF474A {
    static char c;
    static String keyboard[] = {"qwertyuiop", "asdfghjkl;", "zxcvbnm,./"}, in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        c = br.readLine().charAt(0);
        in = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 3; j++) {
                int idx = keyboard[j].indexOf(in.charAt(i));
                if (idx >= 0) {
                    sb.append((c == 'R') ? keyboard[j].charAt(idx - 1) : keyboard[j].charAt(idx + 1));
                    break;
                }
            }
        }
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }
}
