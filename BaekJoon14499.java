import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon14499 {
    static int n, m, x, y, k, dx[] = {0, 0, -1, 1}, dy[] = {1, -1, 0, 0}, map[][], v, q;
    static Dice dice = new Dice(0, 0, 0, 0, 0, 0);
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        x = Integer.parseInt(ins[2]);
        y = Integer.parseInt(ins[3]);
        k = Integer.parseInt(ins[4]);
        map = new int[n][m];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            v = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                map[i][v++] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            q = Integer.parseInt(st.nextToken());
            int top = processing(q - 1);
            if (top >= 0) sb.append(top).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }

    private static int processing(int d) {
        int nx = x + dx[d], ny = y + dy[d];
        if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) return -1;
        dice.tumble(d);
        if (map[nx][ny] == 0) map[nx][ny] = dice.bottom;
        else {
            dice.bottom = map[nx][ny];
            map[nx][ny] = 0;
        }
        x += dx[d];
        y += dy[d];
        return dice.top;
    }

    private static class Dice {
        int top, bottom, left, right, front, rear;

        public Dice(int top, int bottom, int left, int right, int front, int rear) {
            this.top = top;this.bottom = bottom;
            this.left = left;this.right = right;
            this.front = front;this.rear = rear;
        }

        public void tumble(int d) {
            int tmp;
            switch (d) {
                case 0 :
                    tmp = this.right;
                    this.right = this.top;
                    this.top = this.left;
                    this.left = this.bottom;
                    this.bottom = tmp;
                    break;
                case 1 :
                    tmp = this.left;
                    this.left = this.top;
                    this.top = this.right;
                    this.right = this.bottom;
                    this.bottom = tmp;
                    break;
                case 2 :
                    tmp = this.rear;
                    this.rear = this.top;
                    this.top = this.front;
                    this.front = this.bottom;
                    this.bottom = tmp;
                    break;
                case 3 :
                    tmp = this.front;
                    this.front = this.top;
                    this.top = this.rear;
                    this.rear = this.bottom;
                    this.bottom = tmp;
                    break;
            }
        }
    }
}
