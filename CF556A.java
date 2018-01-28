import java.io.*;

public class CF556A {
    static int n, zero = 0, one = 0;
    static char cur;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        in = br.readLine();cur = in.charAt(0);
        for (int i = 0; i < n; i++) {
            zero += (in.charAt(i) == '0') ? 1 : 0;
            one += (in.charAt(i) == '1') ? 1 : 0;
        }
        bw.write(zero + one - (Math.min(zero, one) << 1) + "\n");
        bw.flush();bw.close();
    }
}
