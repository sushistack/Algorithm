import java.io.*;

public class CF69A {
    static int n, x = 0, y = 0, z = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            x += Integer.parseInt(ins[0]);
            y += Integer.parseInt(ins[1]);
            z += Integer.parseInt(ins[2]);
        }
        bw.write((x*x + y*y + z*z > 0) ? "NO\n" : "YES\n");
        bw.flush();bw.close();
    }
}
