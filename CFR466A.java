import java.io.*;
import java.util.StringTokenizer;

public class CFR466A {
    static int n, d, x[] = new int[101], v = 0, max = 0;
    static int b[] = new int[205];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        d = Integer.parseInt(ins[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            x[v] = Integer.parseInt(st.nextToken());
            b[x[v++]]++;
        }
        for (int i = 0; i < 101; i++) {
            int cnt = 0;
            for (int j = i; j <= i + d; j++) {
                cnt += b[j];
            }
            max = Math.max(max, cnt);
        }
        bw.write((n - max) + "\n");
        bw.flush();bw.close();
    }
}
