import java.io.*;

public class B1003 {
    static int T, n, one, zero;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            one = 0;zero = 0;
            fibonacci(n);
            bw.write(zero + " " + one + "\n");
            bw.flush();
        }
        bw.close();
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            one += (n == 1) ? 1 : 0;
            zero += (n == 0) ? 1 : 0;
            return 1;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
