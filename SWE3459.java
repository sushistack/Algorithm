import java.io.*;

public class SWE3459 {
    static int t, T;
    static long n, x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            sb.append("#");sb.append(t - T);sb.append(" ");
            n = Long.parseLong(br.readLine());x = 1;
            if (n == 1L) {
                sb.append("Bob\n");continue;
            }
            if (n == 2L || n == 3L) {
                sb.append("Alice\n");continue;
            }
            int l = (int)Math.log(n) + 2;
            int i = l;
            for (int j = 1; j < i; j++) {
                x <<= 1;
                if (j % 2 == 1) x += (l % 2 == 1) ? 1 : 0;
                else x += (l % 2 == 0) ? 1 : 0;
            }
            if (l % 2 == 0) sb.append((x <= n ? "Alice\n" : "Bob\n"));
            else sb.append((x <= n ? "Bob\n" : "Alice\n"));
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
