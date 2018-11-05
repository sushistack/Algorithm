import java.io.*;
import java.util.StringTokenizer;

public class NHN2 {
    static int n, w, v, circle[] = new int[101];
    static String in, ins[], board[][] = new String[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        w = Integer.parseInt(ins[1]);
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            v = 0;
            while (st.hasMoreTokens()) {
                board[i][v++] = st.nextToken();
            }

        }

        initCircle();
        int p = 0;
        for (int i = n; i > 1; i -= 2) {
            rotate(i, w, p++);
            w *= -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
                if (j < n - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static void rotate(int size, int w, int p) {
        int r = Math.abs(w) % circle[size];
        if (w > 0) {
            while (r-- != 0) {
                rotateRight(size, p);
            }
        } else {
            while (r-- != 0) {
                rotateleft(size, p);
            }
        }
    }

    private static void rotateRight(int size, int p) {
        String tmp = board[p][p];
        for (int i = p; i < p + size - 1; i++) { // 왼쪽위로 올리기
            board[i][p] = board[i + 1][p];
        }
        for (int i = 0; i < p + size - 1; i++) { // 왼쪽으로 밀기
            board[p + size - 1][i] = board[p + size - 1][i + 1];
        }

        for (int i = n - p - 1; i > (n - p) - size; i--) {  // 아래로 밀기
            board[i][n - p - 1] = board[i - 1][n - p - 1];
        }

        for (int i = n - p - 1; i > (n - p) - size + 1; i--) { // 오른쪽으로 밀기
            board[p][i] = board[p][i - 1];
        }
        board[p][p + 1] = tmp;
    }

    private static void rotateleft(int size, int p) {
        String tmp = board[n - p - 1][p];

        for (int i = n - p - 1; i > (n - p) - size; i--) {  // 아래로 밀기
            board[i][p] = board[i - 1][p];
        }

        for (int i = 0; i < p + size - 1; i++) { // 왼쪽으로 밀기
            board[p][i] = board[p][i + 1];
        }

        for (int i = p; i < p + size - 1; i++) { // 왼쪽위로 올리기
            board[i][n - p - 1] = board[i + 1][n - p - 1];
        }

        for (int i = n - p - 1; i > (n - p) - size + 1; i--) { // 오른쪽으로 밀기
            board[n - p - 1][i] = board[n - p - 1][i - 1];
        }
        board[n - p - 1][p + 1] = tmp;
    }

    private static void initCircle() {
        circle[1] = 0;
        circle[2] = 4;
        for (int i = 3; i < 101; i++) {
            circle[i] = i * i - (i - 2) * (i - 2);
        }
    }
}
