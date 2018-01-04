import java.io.*;

public class CF22B {
    static int n, m, l[], r[], max = -1;
    static String ins[], in;
    static boolean[][] table = new boolean[26][26];
    static int[] col = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        for (int i = 0; i < n; i++) {
            in = br.readLine();
            for (int j = 0; j < m; j++) {
                table[i][j] = (in.charAt(j) == '1');
            }
        }

        for (int i = 0; i < n; i++) {

           for (int j = 0; j < m; j++) {
               int r = i, count = 0;
               while (true) {
                   if (!table[r][j]) {
                       count++; r++;
                       if (r == n) break;
                   }else break;
               }
               col[j] = count;
           }
           max = Math.max(max, getMaxPerimeter());
        }
        bw.write(max + "\n");
        bw.flush();bw.close();
    }

    public static int getMaxPerimeter() {
        int maxArea = -1;
        for (int i = 0; i < m; i++) {
            int h = 26, w = 0;
            if (col[i] == 0) continue;
            for (int j = i; j < m; j++) {
                if (col[j] == 0) break;
                w = j - i + 1;
                h = (h > col[j]) ? col[j] : h;
            }
            maxArea = Math.max(maxArea, 2 * (w + h));
        }
        return maxArea;
    }
}
