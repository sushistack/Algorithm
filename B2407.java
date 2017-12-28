import java.io.*;
import java.math.BigInteger;

public class B2407 {
    static int N, M;
    static String in;
    static BigInteger[] factorial = new BigInteger[101];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        N = Integer.parseInt(in.split(" ")[0]);
        M = Integer.parseInt(in.split(" ")[1]);
        factorialInit();
        BigInteger ans = factorial[N].divide(factorial[M].multiply(factorial[N - M]));
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    public static void factorialInit() {
        factorial[1] = BigInteger.ONE;
        for (int i = 2; i < 101; i++) {
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }
    }

}
