import java.io.*;

public class B2448 {
    static int N, rest, quotient;
    static boolean[][] floors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        floors = new boolean[N + 1][(N/3) * 5 + (N/3 - 1)];
        for (int i = 1; i <= N; i++) {
            quotient = i / 3;rest = i % 3;
            switch (rest) {
                case 0: break;          // 5개 짜리
                case 1: break;          // 1개 짜리
                case 2: break;          // 2개 짜리
                default: break;
            }
        }



    }

}
