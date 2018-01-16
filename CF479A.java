import java.io.*;

public class CF479A {
    static int[] a = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 3; i++) a[i] = Integer.parseInt(br.readLine());
        int max = a[0] + a[1] + a[2];
        max = Math.max(max, (a[0] + a[1]) * a[2]);
        max = Math.max(max, (a[1] + a[2]) * a[0]);
        max = Math.max(max, (a[0] * a[1]) + a[2]);
        max = Math.max(max, (a[1] * a[2]) + a[0]);
        max = Math.max(max, a[0] * a[1] * a[2]);
        bw.write(max + "\n");
        bw.flush();bw.close();
    }
}
