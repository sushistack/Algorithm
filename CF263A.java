import java.io.*;

public class CF263A {
    static int x, y, ans = 0;
    static int[][] map = new int[6][6];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < 6; i++) {
            ins = br.readLine().split(" ");
            for (int j = 1; j < 6; j++) {
                if (ins[j - 1].equals("1")) {
                    x = i; y = j;
                }
            }
        }
        ans += (Math.abs(x - 3) + Math.abs(y - 3));
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
