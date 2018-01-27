import java.io.*;

public class CFER36A {
    static int n, k, hour = Integer.MAX_VALUE, y;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        k = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            y = Integer.parseInt(ins[i]);
            if(k % y == 0 && k / y < hour) hour = k / y;
        }
        bw.write(hour + "\n");
        bw.flush();bw.close();
    }
}
