import java.io.*;

public class B10250 {
    static int T, H, W, N, count, r, c;
    static String in;
    static boolean[][] hotel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            in = br.readLine();count = 0;r = 0; c = 0;
            H = Integer.parseInt(in.split(" ")[0]);
            W = Integer.parseInt(in.split(" ")[1]);
            N = Integer.parseInt(in.split(" ")[2]);
            hotel = new boolean[H + 1][W + 1];

            for (int j = 1; j < hotel[0].length; j++) {
                for (int k = 1; k < hotel.length; k++) {
                    hotel[k][j] = true;count++;
                    if (count == N) {
                        r = k;c = j;break;
                    }
                }
                if (count == N) break;
            }
            bw.write(r + "" + ((c < 10) ? "0" + c : c) + "\n");bw.flush();
        }
        bw.close();
    }
}
