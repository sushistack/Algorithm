import java.io.*;
import java.util.Arrays;

public class B10809 {
    static int[] alphabet = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine();
        Arrays.fill(alphabet, -1);
        for (int i = 0; i < in.length() ; i++) {
            if (alphabet[in.charAt(i) - 97] == -1)
                alphabet[in.charAt(i) - 97] = i;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i] + " ");
        }
        bw.write(sb.toString().substring(0, sb.length() - 1) + "\n");
        bw.flush();bw.close();
    }
}
