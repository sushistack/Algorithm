import java.io.*;

public class CF119A {
    static int a, b, n;
    static String ins[];
    static boolean wasWon;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        a = Integer.parseInt(ins[0]);
        b = Integer.parseInt(ins[1]);
        n = Integer.parseInt(ins[2]);
        while (true) {
            n -= gcd(a, n);
            if (n == 0) {
                wasWon = true;break;
            }
            n -= gcd(b, n);
            if (n == 0) {
                wasWon = false;break;
            }
        }
        bw.write((wasWon) ? "0\n" : "1\n");
        bw.flush();bw.close();
    }
    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
