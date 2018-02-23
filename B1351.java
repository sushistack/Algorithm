import java.io.*;
import java.util.HashMap;

public class B1351 {
    static int P, Q;
    static long N;
    static String ins[];
    static HashMap<Long, Integer> dp = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        N = Long.parseLong(ins[0]);
        P = Integer.parseInt(ins[1]);
        Q = Integer.parseInt(ins[2]);
        dp.put(0L, 1);
        bw.write(dp(N) + "\n");
        bw.flush();bw.close();
    }

    public static int dp(long n) {
        if (dp.containsKey(n)) return dp.get(n);
        double x = Math.round((double)n / P);
        double y = Math.round((double)n / Q);
        dp.put(n, dp((long)x) + dp((long)y));
        return dp.get(n);
    }
}
