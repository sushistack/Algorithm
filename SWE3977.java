import java.io.*;

public class SWE3977 {
    static int t, T, l, r, c = 0;
    static boolean isPrime[] = new boolean[(int)10e6 + 1];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        initPrime();
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            ins = br.readLine().split(" ");
            l = Integer.parseInt(ins[0]);
            r = Integer.parseInt(ins[1]);
            int count = 0;
            for (int i = l; i <= r; i++) {
                if (i == 2) count++;
                if (!isPrime[i] && i % 4 == 1) count++;
            }
            sb.append("#");sb.append(t - T);
            sb.append(" ");sb.append(count);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
    private static void initPrime() {
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i = 2 ; i < 1000001 ; i++){
            for(int j = (i << 1) ; j < 1000001 ; j += i){
                isPrime[j] = true;
            }
        }
    }


}
