import java.io.*;
import java.util.Arrays;

public class CF10B {
    static int N, K, cx, cy;
    static int[] m = new int[1001];
    static boolean[][] table = new boolean[100][100];
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        N = Integer.parseInt(ins[0]);
        K = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        cx = cy = (K % 2 == 0) ? K / 2 : K / 2 + 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(ins[i - 1]);
            int min = Integer.MAX_VALUE;
            Point p = new Point();
            for (int x = 1; x <= K; x++) {
                for (int y = 1; y <= K - m[i] + 1; y++) {
                    int abDistance = 0;
                    boolean flag = true;
                    for (int j = y; j < y + m[i]; j++) {
                        if (table[x][j]) {
                            flag = false;break;
                        }
                        abDistance += absoluteD(x, j);
                    }
                    if (flag && min > abDistance) {
                        min = abDistance;
                        p.x = x;p.y = y;
                    }
                }
            }
            Arrays.fill(table[p.x], p.y, p.y + m[i], true);
            sb.append(((p.x == 0) ? -1 : p.x + " " + p.y + " " + (p.y + m[i] - 1)) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();

    }
    public static int absoluteD(int x, int y) {
        return Math.abs(x - cx) + Math.abs(y - cy);
    }

    private static class Point {
        int x, y;
        Point() { x = 0; y = 0; }
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
