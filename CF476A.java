import java.io.*;

public class CF476A {
    static int n, m, c, count = -1;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        c =  (n % 2 == 0) ? n >> 1 : (n >> 1) + 1;
        while (c <= n) {
            if (c % m == 0) {
                count = c;break;
            }
            c++;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
