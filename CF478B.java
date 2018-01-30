import java.io.*;

public class CF478B {
    static int n, m;
    static long min, max;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        if (n < 2) min = max = 0;
        else {
            if (m < 2) min = max = combination(n);
            else {
                max = combination(n - (m - 1));
                int x = n / m, y = n % m;
                min = (long)(m - y) * combination(x) + (long)y * combination(x + 1);
            }
        }
        bw.write(min + " " + max + "\n");
        bw.flush();bw.close();
    }
    public static long combination(long a) {
        return (a * (a - 1)) >> 1;
    }
}
