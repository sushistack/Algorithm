import java.io.*;
import java.util.Arrays;

public class CF723A {
    static int[] x = new int[3];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            x[i] = Integer.parseInt(ins[i]);
        }
        Arrays.sort(x);
        bw.write(x[2] - x[0] + "\n");
        bw.flush();bw.close();
    }
}
