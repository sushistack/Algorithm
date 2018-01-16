import java.io.*;

public class CF469A {
    static int n, p, q;
    static String ins[];
    static boolean[] b = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        p = Integer.parseInt(ins[0]);
        for (int i = 1; i <= p; i++) {
            b[Integer.parseInt(ins[i])] = true;
        }
        ins = br.readLine().split(" ");
        q = Integer.parseInt(ins[0]);
        for (int i = 1; i <= q; i++) {
            b[Integer.parseInt(ins[i])] = true;
        }
        boolean isGameClear = true;
        for (int i = 1; i <= n; i++) {
            if (!b[i]) isGameClear = false;
        }
        bw.write((isGameClear) ? "I become the guy.\n" : "Oh, my keyboard!\n");
        bw.flush();bw.close();
    }
}
