import java.util.Scanner;

public class BaekJoon14500 {
    static int N, M;
    static int[][] table;
    static int[][][] blocks = new int[19][][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();M = sc.nextInt();
        table = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        initBlocks();
        scan();
    }
    public static void initBlocks () {
        int[][] b = {{1, 1},{1, 1}};
        int[][] s = {{1, 1, 0},{0, 1, 1}};
        int[][] h = {{1, 1, 1},{0, 1, 0}};
        int[][] f = {{1, 0, 0},{1, 1, 1}};
        int[][] l = {{1,1,1,1}};
        blocks[0] = b;blocks[1] = s;blocks[5] = h;blocks[9] = f;blocks[17] = l;
        blocks[2] = rotate(blocks[1]);blocks[3] = symmetry(blocks[1]);
        blocks[4] = rotate(blocks[3]);blocks[13] = symmetry(blocks[9]);
        for (int i = 6; i < blocks.length; i++) {
            if (i == 9 || i == 13 || i == 17) continue;
            blocks[i] = rotate(blocks[i - 1]);
        }
    }
    public static int[][] symmetry(int[][] b) {
        int[][] symmetricBlock = new int[b.length][b[0].length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                symmetricBlock[(b.length - 1) - i][j] = b[i][j];
            }
        }
        return symmetricBlock;
    }
    public static int[][] rotate(int [][] b) {
        int[][] rotatedBlock = new int[b[0].length][b.length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                rotatedBlock[j][(b.length - 1) - i] = b[i][j];
            }
        }
        return rotatedBlock;
    }
    public static void print(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void scan() {
        int max = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (j + blocks[i].length <= N && k + blocks[i][0].length <= M)
                        max = Math.max(sumOfBlock(blocks[i], j, k), max);
                }
            }
        }
        System.out.println(max);
    }
    public static int sumOfBlock(int[][] b, int x, int y) {
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                sum += table[x + i][y + j] * b[i][j];
            }
        }
        return sum;
    }
}
