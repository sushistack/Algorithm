import java.io.*;

public class B1676 {
    static int N, count = 0;
    static Ten[] twoOrFive = new Ten[501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        twoOrFive[0] = new Ten(0 , 0);
        for (int i = 1; i <= N; i++) {
            int two = 0, five = 0;
            if (i % 2 == 0) {
                int tmp = i;
                while (tmp % 2 == 0) {
                    tmp >>= 1;two++;
                }
            }
            if (i % 5 == 0) {
                int tmp = i;
                while (tmp % 5 == 0) {
                    tmp /= 5;five++;
                }
            }
            twoOrFive[i] = new Ten(twoOrFive[i - 1].two + two, twoOrFive[i - 1].five + five);
        }

        int ans = (twoOrFive[N].five > twoOrFive[N].two) ? twoOrFive[N].two : twoOrFive[N].five;

        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
    private static class Ten {
        int two, five;
        Ten(int two, int five) {
            this.two = two; this.five = five;
        }
    }
}
