import java.io.*;

public class B2577 {
    static int A, B, C, sum;
    static String result;
    static int[] number = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        A = Integer.parseInt(br.readLine().split(" ")[0]);
        B = Integer.parseInt(br.readLine().split(" ")[0]);
        C = Integer.parseInt(br.readLine().split(" ")[0]);
        sum = A * B * C;result = "" + sum;
        for (int i = 0; i < result.length(); i++) {
            number[result.charAt(i) - 48]++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < number.length; i++) {
            sb.append(number[i] + "\n");
        }
        bw.write(sb.toString());bw.flush();bw.close();

    }
}
