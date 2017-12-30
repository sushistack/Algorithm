import java.io.*;

public class B9461 {
    static int T, N, count;
    static long[] p = new long[101];
    static boolean[] isReverse = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        initSeries();
        while (T-- != 0) {
            N = Integer.parseInt(br.readLine());
            bw.write(p[N] + "\n");bw.flush();
        }
        bw.close();
    }
    public static void initSeries() {
        p[1] = 1;p[2] = 1; isReverse[2] = true;
        p[3] = 1;p[4] = 2; isReverse[4] = true;
        for (int i = 5; i <= 100; i++) {
            count = 0;boolean previousDirection = isReverse[i - 1];
            long sum = 0;
            for (int j = i - 1; j > 0; j--) {
                if (isReverse[j] == previousDirection) {
                    count++;sum += (count != 2) ? p[j] : 0;
                }
                if (count == 3) break;
            }
            isReverse[i] = !isReverse[i - 1];
            p[i] = (count == 3) ? sum : p[i - 1];
        }
    }
}
