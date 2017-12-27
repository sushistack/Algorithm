import java.io.*;
import java.util.Arrays;

public class B1316 {
    static int N, count;
    static String in;
    static boolean flag;
    static boolean[] alphabet = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            in = br.readLine();
            flag = true;Arrays.fill(alphabet, false);
            for (int i = 0; i < in.length() - 1; i++) {
                if (alphabet[in.charAt(i) - 97]) {
                    flag = false; break;
                }
                if (in.charAt(i + 1) != in.charAt(i)) {
                    alphabet[in.charAt(i) - 97] = true;
                }
            }
            if (alphabet[in.charAt(in.length() - 1) - 97]) flag = false;
            count += (flag) ? 1 : 0;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
