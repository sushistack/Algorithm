import java.io.*;
import java.util.Arrays;

public class B2750 {
    static int N;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
