import java.io.*;

public class CF599A {
    static int d[] = new int[3], min = Integer.MAX_VALUE;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) d[i] = Integer.parseInt(ins[i]);
        min = Math.min(min, ((d[0] + d[1]) << 1));
        min = Math.min(min, ((d[0] + d[2]) << 1));
        min = Math.min(min, ((d[1] + d[2]) << 1));
        min = Math.min(min, d[0] + d[1] + d[2]);
        bw.write(min + "\n");
        bw.flush();bw.close();
    }
}
