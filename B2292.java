import java.io.*;

public class B2292 {
    static int idx = 0;
    static long K;
    static long [] hex = new long[100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Long.parseLong(br.readLine());
        initHexagonSeries();
        for (int i = 0; i < 100000; i++) {
            idx = (hex[i] < K) ? i : idx;
            if (hex[i] >= K) break;
        }
        bw.write((K == 1) ? "1\n":idx + 2 + "\n");
        bw.flush();bw.close();
    }
    public static void initHexagonSeries() {
        int term;
        hex[0] = 1;hex[1] = 7;
        for (int i = 2; i < 100000; i++) {
            hex[i] = (hex[i - 1] << 1) - hex[i - 2] + 6;
        }
    }
}
