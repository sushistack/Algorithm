import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class SWE1824 {
    final static int L = 0, R = 1, U = 2, D = 3;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int T, t, r, c, d;
    static char[][] map = new char[21][21];
    static String in, ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());T = t;
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            r = Integer.parseInt(ins[0]);
            c = Integer.parseInt(ins[1]);
            for (int i = 0; i < 21; i++) {
                Arrays.fill(map[i], '\0');
            }
            char cur;
            int mem = 0;
            for (int i = 0; i < r; i++) {
                in = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = in.charAt(j);
                }
            }
            cur = map[0][0];d = R;
            Point p = new Point(0,0);
            int status = 0;
            Random ran = new Random();
            while (status != 1 && status != 2) {
                switch (cur) {
                    case '<': d = L; break;
                    case '>': d = R; break;
                    case '^': d = U; break;
                    case 'v': d = D; break;
                    case '_': d = (mem == 0) ? R : L; break;
                    case '|': d = (mem == 0) ? D : U; break;
                    case '?': d = ran.nextInt(4);break;
                    case '.': status = 2; break;
                    case '@': status = 1; break;
                    case '0':case '1':case '2':case '3':case '4':
                    case '5':case '6':case '7':case '8':case '9':
                        mem = cur - 48; break;
                    case '+': mem = (mem == 15) ? 0 : mem + 1; break;
                    case '-': mem = (mem == 0) ? 15 : mem - 1; break;
                }
                p.x += dx[d];p.y += dy[d];
                p.x = (p.x < 0) ? r - 1 : p.x;
                p.x = (p.x > r - 1) ? 0 : p.x;
                p.y = (p.y < 0) ? c - 1 : p.y;
                p.y = (p.y > c - 1) ? 0 : p.y;
                cur = map[p.x][p.y];
            }
            bw.write((status == 1) ? "YES\n" : "NO\n");
            bw.flush();
        }
        bw.close();

    }
    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;this.y = y;
        }
    }
}
