import java.io.*;

public class CF11A {
    static int n, d, count = 0;
    static String[] in;
    static int[] b = new int[2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        d = Integer.parseInt(in[1]);
        in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(in[i]);
        }
        for (int i = 1; i < n; i++) {
            if (b[i - 1] >= b[i]) {
                int t = b[i - 1] - b[i];
                int s = t / d + 1;
                b[i] += s * d;
                count += s;
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
