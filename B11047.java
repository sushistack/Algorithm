import java.io.*;

public class B11047 {
    static int n, k, a[] = new int[10], idx = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            idx = (a[i] <= k) ? i : idx;
        }
        int count = 0;
        while (k != 0) {
            count += k / a[idx];
            k -= (k / a[idx]) * a[idx--];
        }
        bw.write(count + "\n");
        bw.flush();bw.close();

    }
}
