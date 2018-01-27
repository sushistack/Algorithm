import java.io.*;

public class CF581A {
    static int a, b, ans, s;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        a = Integer.parseInt(ins[0]);
        b = Integer.parseInt(ins[1]);
        if (a < b) {
            ans = a; b -= a;
            s = (b >> 1);
        }else {
            ans = b; a -= b;
            s = (a >> 1);
        }
        bw.write(ans + " " + s + "\n");
        bw.flush();bw.close();

    }
}
