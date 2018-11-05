import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon13458 {
    static int n, a[] = new int[1000001], b, c, v;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            a[v++] = Integer.parseInt(st.nextToken());
        }
        ins = br.readLine().split(" ");
        b = Integer.parseInt(ins[0]);
        c = Integer.parseInt(ins[1]);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += 1;
            a[i] -= b;
            if (a[i] < 0) continue;
            ans += a[i] / c;
            ans += (a[i] % c == 0) ? 0 : 1;
        }

        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
