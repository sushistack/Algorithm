import java.io.*;

public class B1929 {
    static int M, N;
    static String in;
    static boolean isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        M = Integer.parseInt(in.split(" ")[0]);
        N = Integer.parseInt(in.split(" ")[1]);
        StringBuffer sb = new StringBuffer();
        for (int i = M; i <= N; i++) {
            isPrime = (i != 1);
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false; break;
                }
            }
            if (isPrime) sb.append(i + "\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
