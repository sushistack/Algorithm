import java.io.*;

public class CF96A {
    static String in;
    static int count = 0, pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();pre = in.charAt(0);
        for (int i = 1; i < in.length(); i++) {
            count = (in.charAt(i) == pre) ? count + 1 : 0;
            pre = in.charAt(i);
            if (count == 6) break;
        }
        bw.write((count == 6) ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
