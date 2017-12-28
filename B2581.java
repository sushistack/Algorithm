import java.io.*;

public class B2581 {
    static int M, N, min = 10001, sum = 0;
    static boolean isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        for (int i = M; i <= N; i++) {
            isPrime = (i != 1);
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false; break;
                }
            }
            if (isPrime) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if (sum == 0 || min == 10001) {
            bw.write("-1\n");
        }else {
            bw.write(sum + "\n" + min + "\n");
        }

        bw.flush();bw.close();
    }
}
