import java.io.*;

public class CF579A {
    static int x, count;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        x = Integer.parseInt(br.readLine());
        s = Integer.toBinaryString(x);
        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == '1') ? 1 : 0;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
