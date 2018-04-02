import java.io.*;
import java.util.StringTokenizer;

public class CFR469B {
    static int n, m, x[] = new int [100001], y[] = new int[100001], i = 0;
    static String ins[], in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        in = br.readLine();
        StringTokenizer st = new StringTokenizer(in, " ");
        while (st.hasMoreTokens()) x[i++] = Integer.parseInt(st.nextToken());
        in = br.readLine();i = 0;
        st = new StringTokenizer(in);
        while (st.hasMoreTokens()) y[i++] = Integer.parseInt(st.nextToken());
        int top, bottom, p1, p2, count;
        p1 = p2 = count = 0;
        top = x[p1];bottom = y[p2];
        while (!(p1 > n - 1 || p2 > m - 1)) {
            if (top == bottom) {
                top = bottom = 0;
                count++;p1++;p2++;
                top += x[p1];
                bottom += y[p2];
            }else {
                if (top > bottom) {
                    p2++;
                    bottom += y[p2];
                }
                else {
                    p1++;
                    top += x[p1];
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
