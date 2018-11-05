import java.io.*;
import java.util.StringTokenizer;

public class B14888 {
    static int n, op[] = new int[4], v, a[] = new int[11], cnt, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            a[v++] = Integer.parseInt(st.nextToken());
        }
        ins = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(ins[i]);
            cnt += op[i];
        }
        dfs(0, a[0], op);
        bw.write(max + "\n" + min + "\n");
        bw.flush();bw.close();
    }

    private static void dfs(int i, int res, int[] op) {
        if (i == cnt) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int j = 0; j < 4; j++) {
            if (op[j] == 0) continue;
            int tmp = res;
            switch (j) {
                case 0 : tmp += a[i + 1]; break;
                case 1 : tmp -= a[i + 1]; break;
                case 2 : tmp *= a[i + 1]; break;
                case 3 : tmp /= a[i + 1]; break;
            }
            op[j]--;
            dfs(i + 1, tmp, op);
            op[j]++;
        }
    }

}
