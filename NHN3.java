import java.io.*;
import java.util.StringTokenizer;

public class NHN3 {
    static int n, p[], v, max, benefit, sale, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = 0;
        while (st.hasMoreTokens()) {
            p[v++] = Integer.parseInt(st.nextToken());
        }
        benefit = sale = cnt = 0;
        max = p[n - 1];
        for (int i = n - 2; i > -1 ; i--) {
            if (p[i] > max) max = p[i];
            else {
                if (max - p[i] > sale) {
                    sale = max - p[i];
                    cnt++;
                }
                benefit += max - p[i];
            }
        }
        bw.write(benefit - cnt + "\n");
        bw.flush();bw.close();
    }
}
