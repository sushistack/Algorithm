import java.io.*;

public class Line4 {
    static int n, k, m, t;
    final static int MOD = 1003001;
    static int[] factorial = new int[(int)10e5 + 2];
    static int[] inverseFactorial = new int[(int)10e5 + 2];
    static long ans;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        factorialInit();
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- != 0) {
            ins = br.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            k = Integer.parseInt(ins[1]);
            m = Integer.parseInt(ins[2]);

            ans = combination(n, m);
            ans %= MOD;
            ans *= combination(n, k - m);
            ans %= MOD;
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void factorialInit() {
        factorial[0] = inverseFactorial[0] = 1;
        long t = 1;
        for (int i = 1; i < 10e5 + 2; i++) {
            t = (t * i) % MOD;
            factorial[i] = (int)t;
            inverseFactorial[i] = (int)exp(t, MOD - 2);
        }
    }
    private static int combination(int a, int b){
        long e = factorial[a];
        e = ( e * inverseFactorial[b]) % MOD;
        e = (e * inverseFactorial[a-b]) % MOD;
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
