import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CFR480C {
    static int n, k ,p[] = new int[100001], v = 0, np[] = new int[100001];
    static String ins[];
    static boolean b[] = new boolean[256];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            p[v++] = Integer.parseInt(st.nextToken());
        }

        int curKey = (p[0] - k + 1 < 0) ? 0 : p[0] - k + 1;
        np[0] = curKey;
        Arrays.fill(b, curKey, curKey + k, true);
        StringBuilder sb = new StringBuilder(np[0] + " ");
        for (int i = 1; i < n; i++) {
            if (Math.abs(p[i] - curKey) < k) np[i] = curKey;
            else {
                curKey = (p[i] - k + 1 < 0) ? 0 : p[i] - k + 1;
                while (b[curKey]) curKey++;
                Arrays.fill(b, curKey, curKey + k, true);
                np[i] = curKey;
            }
            sb.append(np[i]);
            if (i < n - 1) sb.append(" ");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
