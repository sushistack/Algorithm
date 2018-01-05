import java.io.*;

public class SWE1545 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = n; i > -1; i--) {
            sb.append(i + " ");
        }
        bw.write(sb.toString().substring(0, sb.length() - 1) + "\n");
        bw.flush();bw.close();
    }
}
