import java.io.*;

public class CF133A {
    static String in;
    static boolean isPrint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();isPrint = false;
        for (int i = 0; i < in.length(); i++) {
            switch (in.charAt(i)) {
                case 'H':case 'Q':case '9':
                    isPrint = true;break;
                default:break;
            }
            if (isPrint) break;
        }
        bw.write((isPrint) ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
