import java.io.*;
import java.util.HashMap;

public class CF519B {
    static int n;
    static long[] a = new long[3];
    static HashMap<String, Integer> hm = new HashMap<>();
    static String ins[];
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 3; i++) {
            ins = br.readLine().split(" ");
            for (int j = 1; j <= n - i; j++) {
                a[i] += Integer.parseInt(ins[j - 1]);
            }
        }
        sb.append(a[0] - a[1] + "\n");
        sb.append(a[1] - a[2] + "\n");
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
