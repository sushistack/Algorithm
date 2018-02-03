import java.io.*;

public class BaekJoon1783 {
    static int n, m, count = 1;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        if (n == 2) count = Math.min(4, (m + 1) >> 1);
        else if (n > 2 && m < 7) count = Math.min(4, m);
        else count = m - 2;
        bw.write(count + "\n");
        bw.flush();bw.close();
    }


}
