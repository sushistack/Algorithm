import java.io.*;

public class CF281A {
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        StringBuffer sb = new StringBuffer();
        if (in.charAt(0) > 96) sb.append((char)(in.charAt(0) - 32));
        else sb.append(in.charAt(0));
        sb.append(in.substring(1, in.length()));
        bw.write(sb.toString() + "\n");bw.flush();
        bw.close();
    }
}
