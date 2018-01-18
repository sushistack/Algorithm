import java.io.*;
import java.util.Arrays;

public class CF405A {
    static int n;
    static String ins[];
    static int[] a = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ins[i]);
        }
        Arrays.sort(a, 0, n);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append(a[i] + " ");
        bw.write(sb.toString().substring(0, sb.length() - 1) + "\n");
        bw.flush();bw.close();

    }
}
