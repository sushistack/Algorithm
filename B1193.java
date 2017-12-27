import java.io.*;

public class B1193 {
    static int X, sum = 2, start;
    static int[] series = new int[100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        X = Integer.parseInt(br.readLine());
        initFraction();
        for (int i = 1; i < 100000; i++) {
            sum = (series[i] < X) ? i + 2 : sum;
            if (series[i] >= X) {
                start = series[i - 1];
                break;
            }
        }
        int n, m;
        if (sum % 2 == 0) {// 올라가는 방향
            m = X - start;
            n = sum - m;
        }else { // 내려가는 방향
            n = X - start;
            m = sum - n;
        }
        bw.write(n + "/" + m + "\n");
        bw.flush();bw.close();
    }
    public static void initFraction() {
        series[1] = 1;
        for (int i = 2; i < 100000; i++) {
            series[i] = series[i - 1] + i;
        }
    }
}
