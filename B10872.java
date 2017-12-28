import java.io.*;

public class B10872 {
    final static int MOD = 1000000007;
    static int[] factorial = new int[200001];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        factorialInit();
        bw.write(factorial[N] + "\n");
        bw.flush();bw.close();

    }
    public static void factorialInit() {
        factorial[0] = 1;
        long t = 1;
        for (int i = 1; i < 200001; i++) {
            t = (t * i) % MOD;
            factorial[i] = (int)t;
        }
    }

}
