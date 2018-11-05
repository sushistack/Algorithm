import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B14889 {
    static int n, map[][] = new int[20][20], v, ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            v = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                map[i][v++] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    private static void dfs(int i, int cnt, int status) {
        if (cnt == (n >> 1)) {
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((status & (1 << j)) != 0) x.add(j);
                if ((status & (1 << j)) == 0) y.add(j);
            }
            int sum = 0;
            for (int j = 0; j < x.size() - 1; j++) {
                for (int k = j + 1; k < x.size(); k++) {
                    sum += map[x.get(j)][x.get(k)];
                    sum += map[x.get(k)][x.get(j)];
                    sum -= map[y.get(j)][y.get(k)];
                    sum -= map[y.get(k)][y.get(j)];
                }
            }
            ans = Math.min(ans, Math.abs(sum));
            return;
        }
        if (i == n) return;
        dfs(i + 1, cnt, status);
        dfs(i + 1,cnt + 1, status | (1 << i));
    }

}
