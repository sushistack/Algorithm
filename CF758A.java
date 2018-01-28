import java.io.*;

public class CF758A {
    static int n, a[] = new int[101], max = -1, ans = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ins[i]);
            max = Math.max(max, a[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += (max - a[i]);
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
