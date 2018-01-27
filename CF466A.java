import java.io.*;

public class CF466A {
    static int n, m, a, b;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);m = Integer.parseInt(ins[1]);
        a = Integer.parseInt(ins[2]);b = Integer.parseInt(ins[3]);
        int ans = (b > a * m) ? a * n : (m > n) ? Math.min(b, n * a) : (n / m) * b + Math.min((n % m) * a, b);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
