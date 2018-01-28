import java.io.*;

public class CF791A {
    static int a, b, idx = 0;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        a = Integer.parseInt(ins[0]);
        b = Integer.parseInt(ins[1]);
        while (a <= b) {
            a *= 3;b <<= 1;idx++;
        }
        bw.write(idx + "\n");
        bw.flush();bw.close();
    }
}
