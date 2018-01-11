import java.io.*;

public class CF266A {
    static int n, count = 0, cur;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        in = br.readLine();cur = in.charAt(0);
        for (int i = 1; i < n; i++) {
            count += (cur == in.charAt(i)) ? 1 : 0;
            cur = in.charAt(i);
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
