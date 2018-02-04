import java.io.*;

public class B9663 {
    static int n;
    static String ins[];
    static boolean b[][] = new boolean[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        bw.write(dfs(0) + "\n");
        bw.flush();bw.close();
    }

    public static int dfs(int idx) {
        if (idx == n) return 1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPut(idx, i)) {
                b[idx][i] = true;
                count += dfs(idx + 1);
                b[idx][i] = false;
            }
        }
        return count;
    }

    public static boolean isPut (int idx, int p) {
        for (int i = 0; i < idx; i++) {
            if (b[i][p]) return false;
        }
        int k = 0;
        while (true) {
            if (b[idx - k][p - k]) return false;
            k++;
            if (idx - k < 0 || p - k < 0) break;
        }
        k = 0;
        while (true) {
            if (b[idx - k][p + k]) return false;
            k++;
            if (idx - k < 0 || p + k > n - 1) break;
        }
        return true;
    }


}
