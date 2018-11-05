import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon14500 {
    static int n, m, map[][], v;
    static String ins[];
    static boolean blocks[][][] = {
            {{true, true, true, true}},
            {{true}, {true}, {true}, {true}},
            {{true, true}, {true, true}},

            {{true, false}, {true, false}, {true, true}},
            {{true, true, true}, {false, false, true}},
            {{false, true}, {false, true}, {true, true}},
            {{true, false, false}, {true, true, true}},

            {{true, true, true}, {true, false, false}},
            {{true, true}, {false, true}, {false, true}},
            {{true, true}, {true, false}, {true, false}},
            {{false, false, true}, {true, true, true}},

            {{true, false}, {true, true}, {false, true}},
            {{false, true, true}, {true, true, false}},
            {{false, true}, {true, true}, {true, false}},
            {{true, true, false}, {false, true, true}},

            {{true, true, true}, {false, true, false}},
            {{true, false}, {true, true}, {true, false}},
            {{false, true, false}, {true, true, true}},
            {{false, true}, {true, true}, {false, true}}
            };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        StringTokenizer st;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            v = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                map[i][v++] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(processing() + "\n");
        bw.flush();bw.close();
    }
    private static int processing() {
        int max = 0;
        for (int i = 0; i < blocks.length; i++) {
            max = Math.max(max, getArea(blocks[i]));
        }
        return max;
    }
    private static int getArea(boolean block[][]) {
        int area = 0;

        for (int i = 0; i < n - block.length + 1; i++) {
            for (int j = 0; j < m - block[0].length + 1; j++) {
                area = Math.max(area, getBlockArea(i, j, block));
            }
        }

        return area;
    }

    private static int getBlockArea(int x, int y, boolean block[][]) {
        int area = 0;
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[0].length; j++) {
                area += (block[i][j]) ? map[i + x][j + y] : 0;
            }
        }
        return area;
    }
}
