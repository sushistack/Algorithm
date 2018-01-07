import java.io.*;

public class SWE1222 {
    static int n, t = 10;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            ins = br.readLine().split("\\+");
            int ans = 0;
            for (int i = 0; i < ins.length; i++) {
                ans += Integer.parseInt(ins[i]);
            }
            bw.write("#" + (10 - t) + " " + ans + "\n");
            bw.flush();
        }
        bw.close();
    }
}
