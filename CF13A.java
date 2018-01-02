import java.io.*;

public class CF13A {
    static int A;
    static long sum;
    static String hex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        A = Integer.parseInt(br.readLine());
        for (int i = 2; i < A; i++) {
            sum += sumOfDecimalToBaseN(i, A);
        }
        int b = A - 2;
        long g = gcd(sum, b);
        sum /= g; b /= g;


        bw.write(sum + "/" + b + "\n");
        bw.flush();bw.close();
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }

    public static long sumOfDecimalToBaseN(int n, int a) {
        long ans = 0;
        while (a != 0) {
            int r = a % n;
            ans += r;
            a /= n;
        }
        return ans;
    }

}
