import java.io.*;

public class CF118A {
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < in.length(); i++) {
            switch (in.charAt(i)) {
                case 'A':case 'O':case 'Y':
                case 'E':case 'U':case 'I':
                case 'a':case 'o':case 'y':
                case 'e':case 'u':case 'i':
                    sb.append("");break;
                default: sb.append("." + in.charAt(i));break;
            }
        }
        String t = sb.toString().toLowerCase();
        bw.write(t + "\n");bw.flush();
        bw.close();
    }
}
