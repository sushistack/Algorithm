import java.io.*;

public class CF427A {
    static int n, p = 0, count = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (p > 0) {
                if (ins[i].equals("-1")) p--;
                else p += Integer.parseInt(ins[i]);
            }else {
                if (ins[i].equals("-1")) count++;
                else p += Integer.parseInt(ins[i]);
            }
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
