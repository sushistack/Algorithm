import java.io.*;

public class CFR472B {
    static int n, m;
    static char[][] map = new char[51][];
    static String ins[], in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            in = br.readLine();
            map[i] = in.toCharArray();
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (map[i][j] == '.') continue;
                if (map[i][j] == map[i][j + 1]) {
                    flag = false;break;
                }
            }
            if (!flag) break;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] == '.') continue;
                if (map[j][i] == map[j + 1][i]) {
                    flag = false;break;
                }
            }
            if (!flag) break;
        }
        bw.write((flag) ? "Yes\n" : "No\n");
        bw.flush();bw.close();
    }
}
