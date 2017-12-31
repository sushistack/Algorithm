import java.io.*;

public class CF4A {
    static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        w = Integer.parseInt(br.readLine());
        bw.write((w % 2 == 0 && w > 2) ? "YES\n" : "NO\n");
        bw.flush();bw.close();
    }
}
