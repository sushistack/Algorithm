import java.io.*;

public class CFR468A {
    static int a, b, increasing[] = new int[1001], ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        initIncreasing();
        int ave = (a + b) >> 1;
        ans += increasing[Math.abs(ave - a)];
        ans += increasing[Math.abs(ave - b)];
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    private static void initIncreasing() {
        increasing[0] = 0;
        for (int i = 1; i < 1001; i++) {
            increasing[i] = increasing[i - 1] + i;
        }
    }
}
