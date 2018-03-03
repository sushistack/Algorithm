import java.io.*;
import java.util.Arrays;

public class SWE2063 {
    static int n, a[] = new int[200];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(ins[i]);
        Arrays.parallelSort(a, 0, n);
        bw.write(a[(n >> 1)] + "\n");
        bw.flush();bw.close();
    }
}
