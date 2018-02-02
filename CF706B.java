import java.io.*;
import java.util.Arrays;

public class CF706B {
    static int n, q, x[] = new int[100001], m;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(ins[i]);
        }
        Arrays.sort(x, 0, n);
        q = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < q; i++) {
            m = Integer.parseInt(br.readLine());
            int idx;

            if (m < x[0]) idx = 0;
            else if (m > x[n - 1]) idx = n;
            else idx = binarySearch(0, n, m);
            sb.append(idx);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    public static int binarySearch(int l, int r, int m) {
        while (r - l > 1) {
            int mid = (l + r) >> 1;
            if (m < x[mid]) r = mid;
            else l = mid;
        }
        return l + 1;
    }
}
