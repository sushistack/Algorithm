import java.io.*;

public class CF617A {
    static int n, t, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 5; i > 0; i--) {
            if (n >= i) {
                t = n / i;
                n -= t * i;
                count += t;
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
