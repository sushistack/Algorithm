import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CFR467A {
    static int n, a[] = new int[101], v = 0, cnt = 0, cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            a[v++] = Integer.parseInt(st.nextToken());
        }
        Arrays.parallelSort(a, 0, n);
        cur = a[n - 1];cnt = 1;
        for (int i = n - 2; i > -1 ; i--) {
            if (a[i] == 0) break;
            if (cur == a[i]) continue;
            cur = a[i];
            cnt++;
        }
        bw.write(cnt + "\n");
        bw.flush();bw.close();
    }

}
