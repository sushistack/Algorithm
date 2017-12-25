import java.io.*;

public class B11720 {
    static int N, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String in = br.readLine();
        for (int i = 0; i < in.length(); i++) {
            ans += in.charAt(i) - 48;
        }
        bw.write(ans + "\n");bw.flush();
        bw.close();
    }
}
