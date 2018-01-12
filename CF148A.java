import java.io.*;

public class CF148A {
    static int k, l, m, n, d, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());l = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());n = Integer.parseInt(br.readLine());
        d = Integer.parseInt(br.readLine());
        for (int i = 1; i < d + 1; i++) {
            if (i % k == 0 || i % l == 0 || i % m == 0 || i % n == 0) count++;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
