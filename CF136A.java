import java.io.*;

public class CF136A {
    static int n;
    static int[] a = new int[101];
    static int[] b = new int[101];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(ins[i - 1]);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) b[a[i]] = i;
        for (int i = 1; i <= n; i++) sb.append(b[i] + " ");
        bw.write(sb.toString().substring(0, sb.length() - 1));
        bw.flush();bw.close();
    }
}
