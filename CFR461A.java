import java.io.*;

public class CFR461A {
    static int x, y, copied = 0;
    static String ins[];
    static boolean isCase = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        x = Integer.parseInt(ins[0]);
        y = Integer.parseInt(ins[1]);
        copied = y - 1;
        if (x < copied) isCase = false;
        if ((x - copied) % 2 == 1) isCase = false;
        bw.write((!isCase) ? "No\n" : "Yes\n");
        bw.flush();bw.close();
    }
}
