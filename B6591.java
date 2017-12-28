import java.io.*;

public class B6591 {
    static int N, M;
    static int[] a = new int[101];
    static int[] b = new int[101];
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!(in = br.readLine()).equals("0 0")) {
            N = Integer.parseInt(in.split(" ")[0]);
            M = Integer.parseInt(in.split(" ")[1]);
            int topEnd, bottom;
            topEnd = (N - M > M) ? N - M : M;
            bottom = N - topEnd;
            for (int i = N; i > topEnd; i--) {
                a[N - i] = i;
            }
            for (int i = 1; i <= bottom; i++) {
                b[i - 1] = i;
            }

            for (int i = 0; i < bottom; i++) {
                for (int j = 0; j < N - topEnd; j++) {
                    int gcd = gcd(b[i], a[j]);
                    if (gcd > 1) {
                        a[j] /= gcd; b[i] /= gcd;
                    }
                }
            }
            long ans = 1;
            for (int i = 0; i < N - topEnd; i++) {
                if (a[i] == 0) break;
                ans *= a[i];
            }
            for (int i = 0; i < bottom; i++) {
                ans /= b[i];
            }
            bw.write(ans + "\n");
            bw.flush();
        }
        bw.close();
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
}
