import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B4673 {
    static int[] generator = new int[20001];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        d();StringBuffer sb = new StringBuffer();
        for (int i = 1 ; i < 10001; i++) {
            sb.append((generator[i] == 0) ? i + "\n" : "");
        }
        bw.write(sb.toString());bw.flush();bw.close();
    }

    public static void d() {
        for (int i = 1; i < 10001; i++) {
            String s = i + "";
            int index = Integer.parseInt(s);
            for (int j = 0; j < s.length(); j++) {
                index += s.charAt(j) - 48;
            }
            generator[index]++;
        }
    }
}
