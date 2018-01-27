import java.io.*;

public class CF313A {
    static int max;
    static String n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = br.readLine();
        max = Integer.parseInt(n);
        if (max < 0) {
            for (int i = n.length() - 2; i < n.length(); i++) {
                m = n.substring(0, i) + n.substring(i + 1, n.length());
                max = Math.max(max, Integer.parseInt(m));
            }
        }
        bw.write(max + "\n");
        bw.flush();bw.close();
    }
}
