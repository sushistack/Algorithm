import java.io.*;

public class CF282A {
    static int n, ans = 0;
    static String in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            in = br.readLine().replace("X", "");
            ans += (in.equals("++")) ? 1 : -1;
        }
        bw.write(ans + "\n");bw.flush();bw.close();
    }
}
