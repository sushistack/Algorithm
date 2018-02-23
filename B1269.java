import java.io.*;
import java.util.Arrays;

public class B1269 {
    static int A, B, a[] = new int[200001], b, ans = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        A = Integer.parseInt(ins[0]);
        B = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 0; i < A; i++) a[i] = Integer.parseInt(ins[i]);
        Arrays.parallelSort(a, 0, A);
        ins = br.readLine().split(" ");
        for (int i = 0; i < B; i++) {
            b = Integer.parseInt(ins[i]);
            ans += (Arrays.binarySearch(a, 0, A, b) < 0) ? 0 : 1;
        }
        bw.write((A - ans) + (B - ans) + "\n");
        bw.flush();bw.close();
    }
}
