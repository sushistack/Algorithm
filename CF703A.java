import java.io.*;

public class CF703A {
    static int n, m = 0, c = 0, x, y;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            x = Integer.parseInt(ins[0]);
            y = Integer.parseInt(ins[1]);
            m += (x > y) ? 1 : 0;
            c += (y > x) ? 1 : 0;
        }
        bw.write((m > c) ? "Mishka\n" : (m == c) ? "Friendship is magic!^^\n" : "Chris\n");
        bw.flush();bw.close();
    }
}
