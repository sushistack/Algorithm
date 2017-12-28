import java.io.*;

public class B6064 {
    static int T, N, M, x, y;
    static String in;
    static boolean isDay;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            in = br.readLine();isDay = false;
            M = Integer.parseInt(in.split(" ")[0]);
            N = Integer.parseInt(in.split(" ")[1]);
            x = Integer.parseInt(in.split(" ")[2]);
            y = Integer.parseInt(in.split(" ")[3]);
            int result = -1;
            for(int j = 0; j < N; j++) {
                if((j * M + x - 1) % N + 1 == y) {
                    result = j * M + x;
                    break;
                }
            }
            bw.write(result + "\n");
            bw.flush();
        }
        bw.close();
    }

}
