import java.io.*;

public class CF116A {
    static int n, a, b, max = 0, cur = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            a = Integer.parseInt(ins[0]);
            b = Integer.parseInt(ins[1]);
            cur -= a; cur += b;
            max = Math.max(max, cur);
        }
        bw.write(max + "\n");
        bw.flush();bw.close();
    }
}
