import java.io.*;

public class WB4 {
    static int n, v = 0, ans = 0;
    static String ins[], in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");


        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
