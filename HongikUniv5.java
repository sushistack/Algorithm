import java.io.*;

public class HongikUniv5 {
    static long N, a[] = new long[1000001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(ins[i]);
        }
        double min = Double.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < N - 1; i++) {
            if (min > (double)(a[i] + a[i + 1]) / 2.) {
                min = (double)(a[i] + a[i + 1]) / 2.;
                ans = i;
            }
        }
        for (int i = 0; i < N - 2; i++) {
            if (min >= (double)(a[i] + a[i + 1] + a[i + 2]) / 3.) {
                min = (double)(a[i] + a[i + 1] + a[i + 2]) / 3.;
                ans = i;
            }
        }

        bw.write(ans + "\n");
        bw.flush();bw.close();

    }


}
