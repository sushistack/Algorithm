import java.io.*;
import java.util.Arrays;

public class B1011 {
    static int T, x, y, ans, e;
    static long[] md = new long[100000];
    static long pos;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        initMobileDevice();
        for (int i = 0; i < T; i++) {
            in = br.readLine();
            x = Integer.parseInt(in.split(" ")[0]);
            y = Integer.parseInt(in.split(" ")[1]);
            pos = 0;e = y - x;
            ans = Arrays.binarySearch(md, e);
            if (ans < 0) {
                ans = Math.abs(ans) - 1;
            }
            bw.write(ans + "\n");
            bw.flush();
        }
        bw.close();
    }
    public static void initMobileDevice() {
        md[1] = 1;
        for (int i = 2; i < 100000; i++) {
            md[i] = ((long)i / 2) * (((long)i / 2) + 1);
            md[i] += (i % 2 == 0) ? 0 : (i / 2) + 1;
        }
    }

}
