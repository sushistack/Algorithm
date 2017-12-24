import java.io.*;
import java.util.HashMap;

public class B2749 {
    final static int MOD = 1000000;
    static long N;
    static HashMap<Long, long[][]> matrices = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Long.parseLong(br.readLine());
        int ans = (N == 0) ? 0 : 1;
        long[][] zeroMatrix = {{0, 0},{0 , 0}};
        long[][] initMatrix = {{1, 1},{1 , 0}};
        matrices.put((long)0, zeroMatrix);matrices.put((long)1, initMatrix);
        if (N > 2) {
            long[][] mat = getMatrix(N - 2);
            ans = (int) (mat[0][0] + mat[0][1]) % MOD;
        }
        bw.write(ans + "\n");bw.flush();bw.close();

    }
    public static long[][] getMatrix(long n) {
        if (n == 1) return matrices.get((long)1);
        else if (matrices.containsKey(n)) return matrices.get(n);
        else {
            matrices.put(n, (n % 2 == 0) ? multiplication(getMatrix(n / 2), getMatrix(n / 2)) :
                    multiplication(getMatrix(n / 2), multiplication(getMatrix(n / 2), getMatrix(1))));
            return matrices.get(n);
        }
    }
    public static long[][] multiplication(long[][] a, long[][] b) {
        long[][] ans = new long[2][2];
        ans[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        ans[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        ans[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        ans[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return ans;
    }
}
