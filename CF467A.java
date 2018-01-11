import java.io.*;

public class CF467A {
    static int n, p, q, count = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");
            p = Integer.parseInt(ins[0]);
            q = Integer.parseInt(ins[1]);
            if (q - p > 1) count++;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
