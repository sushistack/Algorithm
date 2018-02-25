import java.io.*;
import java.util.HashMap;

public class B1351 {
    static int P, Q;
    static long N;
    static String ins[];
    static HashMap<Long, Long> dp = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        N = Long.parseLong(ins[0]);
        P = Integer.parseInt(ins[1]);
        Q = Integer.parseInt(ins[2]);
        dp.put(0L, 1L);
        bw.write(dp(N) + "\n");
        bw.flush();bw.close();
    }

    public static long dp(long n) {
        if (dp.containsKey(n)) return dp.get(n);
        dp.put(n, dp(n / P) + dp(n / Q));
        return dp.get(n);
    }
}
