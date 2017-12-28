import java.io.*;
import java.util.Arrays;

public class B1427 {
    static String in;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();a = new int[in.length()];
        for (int i = 0; i < in.length(); i++) {
            a[i] = in.charAt(i) - 48;
        }
        Arrays.sort(a);
        StringBuffer sb = new StringBuffer();
        for (int i = a.length - 1; i > -1; i--) {
            sb.append(a[i]);
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
