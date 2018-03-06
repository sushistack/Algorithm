import java.io.*;

public class SWE3750 {
    static int t, T, sum;
    static String n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- != 0) {
            n = br.readLine();
            while (n.length() != 1) {
                sum = 0;
                for (int i = 0; i < n.length(); i++) {
                    sum += n.charAt(i) - 48;
                }
                n = sum + "";
            }
            sb.append("#");sb.append(t - T);sb.append(" ");
            sb.append(n);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
