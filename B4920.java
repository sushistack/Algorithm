import java.io.*;
import java.util.StringTokenizer;

public class B4920 {
    static int n, map[][] = new int[100][100], v, t = 1, ans;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (!(in = br.readLine()).equals("0")) {
            n = Integer.parseInt(in.replace(" ", ""));
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                v = 0;
                while (st.hasMoreTokens()) {
                    map[i][v++] = Integer.parseInt(st.nextToken());
                }
            }
            ans = Integer.MIN_VALUE;findMaxArea();
            sb.append(t++);sb.append(". ");
            sb.append(ans);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
    private static void findMaxArea() {
        int blocks[][][] = {
                {{1, 1, 1, 1}},
                {{1}, {1}, {1}, {1}},
                {{1, 1}, {1, 1}},
                {{1, 1, 0}, {0, 1, 1}},
                {{0, 1}, {1, 1}, {1, 0}},
                {{1, 1, 1}, {0, 0, 1}},
                {{1, 1, 1}, {0, 0, 1}},
                {{1, 0, 0}, {1, 1, 1}},
                {{0, 1}, {0, 1}, {1, 1}},
                {{1, 1}, {1, 0}, {1, 0}},
                {{1, 1, 1}, {0, 1, 0}},
                {{0, 1, 0}, {1, 1, 1}},
                {{1, 0}, {1, 1}, {1, 0}},
                {{0, 1}, {1, 1}, {0, 1}}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < blocks.length; k++) {
                    if (i + blocks[k].length > n ||
                        j + blocks[k][0].length > n) continue;
                    ans = Math.max(ans, coveredAreaByBlock(blocks[k], i, j));
                }
            }
        }
    }

    private static int coveredAreaByBlock(int[][] b, int x, int y) {
        int sum = 0;
        for (int i = x; i < x + b.length; i++) {
            for (int j = y; j < y + b[0].length; j++) {
                sum += b[i - x][j - y] * map[i][j];
            }
        }
        return sum;
    }
}
