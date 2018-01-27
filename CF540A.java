import java.io.*;

public class CF540A {
    static int n, count = 0;
    static int[] a = new int[1001], b = new int[1001];
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        in = br.readLine();
        for (int i = 0; i < n; i++) a[i] = in.charAt(i) - 48;
        in = br.readLine();
        for (int i = 0; i < n; i++) b[i] = in.charAt(i) - 48;
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) count += Math.min(b[i] - a[i], a[i] + 10 - b[i]);
            else count += Math.min(a[i] - b[i], b[i] + 10 - a[i]);
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
