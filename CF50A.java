import java.io.*;

public class CF50A {
    static int n, m, ans = 0;
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);m = Integer.parseInt(ins[1]);
        ans = (n % 2 == 0) ? (n >> 1) * m : ((n - 1) >> 1) * m + (m >> 1);
        bw.write(ans + "\n");bw.flush();bw.close();
    }
}
