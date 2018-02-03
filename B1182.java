import java.io.*;

public class B1182 {
    static int N, S, a[] = new int[20], ans = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        N = Integer.parseInt(ins[0]);
        S = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(ins[i]);
        boolean b[] = new boolean[20];
        dfs(0, b);
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }

    public static void dfs(int idx, boolean[] b) {
        if (idx == N) {
            boolean isA = true;
            for (int i = 0; i < N; i++) {
                if (b[i]) {
                    isA = false;break;
                }
            }
            int s = 0;


            for (int i = 0; i < N; i++) {
                s += (b[i]) ? a[i] : 0;
            }

            ans += (s == S && !isA) ? 1 : 0;
        }else {
            boolean tb[] = new boolean[20], tb2[] = new boolean[20];
            System.arraycopy(b, 0, tb, 0, 20);
            dfs(idx + 1, tb);
            System.arraycopy(b, 0, tb2, 0, 20);
            tb2[idx] = true;
            dfs(idx + 1, tb2);
        }
    }
}
