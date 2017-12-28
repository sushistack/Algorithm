import java.io.*;

public class B4948 {
    static boolean isPrime;
    static String in;
    static int count, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        while (!(in = br.readLine()).equals("0")) {
            t = Integer.parseInt(in);count = 0;
            for (int i = t + 1; i <= 2*t; i++) {
                isPrime = (i != 1);
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false; break;
                    }
                }
                if (isPrime) count++;
            }
            sb.append(count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
