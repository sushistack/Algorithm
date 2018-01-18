import java.io.*;

public class CF451A {
    static int n, m, count = 0;
    static String ins[];
    static boolean[][] map = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        while (move() != -1) count++;

        bw.write(((count % 2 == 1) ? "Malvika" : "Akshat") + "\n");
        bw.flush();bw.close();
    }
    public static int move() {
        int x = -1, y = -1;
        boolean flag = false;
        for (int i = 0; i < n;) {
            for (int j = 0; j < m;) {
                if (!map[i][j]) {
                    x = i;y = j;flag = true;break;
                }else {
                    i++;j++;
                }
            }
            if (flag) break;
        }
        if (x > -1) {
            for (int i = 0; i < n; i++) map[i][y] = true;
            for (int i = 0; i < m; i++) map[x][i] = true;
        }
        int min = Math.min(n, m);
        boolean flag2 = false;
        for (int i = 0; i < min; i++) {
            if (!map[i][i]) {flag2 = true; break;}
        }

        return (flag2) ? 1 : -1;
    }

}
