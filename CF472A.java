import java.io.*;

public class CF472A {
    static int n, k1 = -1, k2 = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 4; i <= n - 4; i++) {
            if (!isPrime(i) && !isPrime(n - i)) {
                k1 = i;k2 = n - i; break;
            }
        }
        bw.write(k1 + " " + k2 + "\n");
        bw.flush();bw.close();
    }

    public static boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                prime = false; break;
            }
        }
        return prime;
    }
}
