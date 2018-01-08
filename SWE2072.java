import java.io.*;

public class SWE2072 {
    static int t, ans, n;
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            ins = br.readLine().split(" ");ans = 0;
            for (int j = 0; j < 10; j++) {
                n = Integer.parseInt(ins[j]);
                ans += (n % 2 == 1) ? n : 0;
            }
            bw.write("#" + i + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }
}
