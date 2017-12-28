import java.io.*;

public class B11051 {
    final static int MOD = 10007;
    static int[] factorial = new int[200005];
    static int[] inverseFactorial = new int[200005];
    static int N, K;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();factorialInit();
        N = Integer.parseInt(in.split(" ")[0]);
        K = Integer.parseInt(in.split(" ")[1]);
        bw.write(combination(N, K) + "\n");
        bw.flush();bw.close();
    }
    private static void factorialInit() {
        factorial[0] = inverseFactorial[0] = 1;
        long t = 1;
        for (int i = 1; i < 200005; i++) {
            t = (t * i) % MOD;
            factorial[i] = (int)t;
            inverseFactorial[i] = (int)exp(t, MOD - 2);
        }
    }
    private static int combination(int a, int b){
        long e= factorial[a];
        e = (e*inverseFactorial[b]) % MOD;
        e = (e*inverseFactorial[a-b]) % MOD;
        return (int)e;
    }
    private static long exp(long x, int m) {
        if(m==1) return x;
        long t = exp(x,m/2);
        long result = t;
        result = (result * t) % MOD;
        if(m % 2 == 1 ){
            result = (result * x) % MOD;
        }
        return (int) result;
    }
}
