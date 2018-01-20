import java.io.*;

public class CF460A {
    static int n, m, count = 0, t = 1;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        while (n != 0) {
            n += (t == m) ? 1 : 0;
            t = (t == m) ? 1 : t + 1;
            count++;n--;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();

    }
}
