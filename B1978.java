import java.io.*;

public class B1978 {
    static int N, count = 0;
    static String ins[];
    static boolean isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(ins[i]);
            isPrime = !(t == 1);
            for (int j = 2; j <= Math.sqrt(t); j++) {
                if (t % j == 0) {
                    isPrime = false;break;
                }
            }
            if (isPrime) count++;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
