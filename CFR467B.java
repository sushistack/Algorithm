import java.io.*;

public class CFR467B {
    static int p, y, ans = -1;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        p = Integer.parseInt(ins[0]);
        y = Integer.parseInt(ins[1]);
        y -= (y % 2 == 0) ? 1 : 0;
        for (int i = y; i > p; i -= 2) {
            boolean isDivisor = false;
            for (int j = 3; j <= p && j * j <= i; j+=2) {
                if (i % j == 0) {
                    isDivisor = true;break;
                }
            }
            if (!isDivisor) {
                ans = i;break;
            }
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
