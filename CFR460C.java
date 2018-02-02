import java.io.*;

public class CFR460C {
    static int n, m, k, count = 0, t = 0;
    static String ins[], in;
    static char[][] map = new char[2005][2005];
    static int[][] c = new int[2005][2005], r = new int[2005][2005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        k = Integer.parseInt(ins[2]);
        for (int i = 0; i < n; i++) {
            in = br.readLine();
            map[i] = in.toCharArray();
        }

        for (int i = 0; i < n; i++) {
            t = 0;
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '.') t++;
                else {
                    count += Math.max(0, t - k + 1);
                    t = 0;
                }
            }
            count += Math.max(0, t - k + 1);
        }

        for (int i = 0; i < m; i++) {
            t = 0;
            for (int j = 0; j < n; j++) {
                if (map[j][i] == '.') t++;
                else {
                    count += Math.max(0, t - k + 1);
                    t = 0;
                }
            }
            count += Math.max(0, t - k + 1);
        }
        bw.write((k == 1) ? (count >> 1) + "\n" : count + "\n");
        bw.flush();bw.close();
    }
}
