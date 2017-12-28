import java.io.*;

public class B2775 {
    static int T, N, K;
    static int[][] apartment = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        initApartment();
        for (int i = 0;  i < T; i++) {
            N = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());
            bw.write(apartment[N][K] + "\n");
            bw.flush();
        }
        bw.close();
    }
    public static void initApartment() {
        for (int i = 1; i < 15; i++) {
            apartment[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                int sum = 0;
                for (int k = 1; k <= j; k++) {
                    sum += apartment[i - 1][k];
                }
                apartment[i][j] = sum;
            }
        }
    }
}
