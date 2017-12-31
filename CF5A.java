import java.io.*;

public class CF5A {
    static String in;
    static int m = 0, l = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while ((in = br.readLine()) != null){
            if (in.charAt(0) == '+' || in.charAt(0) == '-') {
                m += (in.charAt(0) == '+') ? 1 : -1;
                if (m < 0) m = 0;
            }else {
                String massage = in.substring(in.indexOf(':') + 1, in.length());
                l += massage.length() * m;
            }
        }
        bw.write(l + "\n");
        bw.flush();bw.close();
    }
}
