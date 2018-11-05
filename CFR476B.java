import java.io.*;

public class CFR476B {
    static int n, k, c[][] = new int[101][101];
    static char[][] map = new char[101][101];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        countDecker(true);
        countDecker(false);
        int max = 0, x = 1, y = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < c[i][j]) {
                    max = c[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        bw.write(x + " " + y + "\n");
        bw.flush();bw.close();
    }
    
    private static void countDecker(boolean rowCol) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (k - 1); j++) {
                boolean isDecker = true;
                for (int l = 0; l < k; l++) {
                    char cc = (rowCol) ? map[i][j + l] : map[j + l][i];
                    if (cc == '#') {
                        isDecker = false;
                    }
                }
                if (!isDecker) continue;
                for (int l = 0; l < k; l++) {
                    if (rowCol) c[i][j + l]++;
                    else c[j + l][i]++;
                }
            }
        }
    }
}
