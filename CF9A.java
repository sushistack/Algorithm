import java.io.*;

public class CF9A {
    static int D, max, b = 6;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        max = 7 - Math.max(Integer.parseInt(ins[0]), Integer.parseInt(ins[1]));
        if (max % 2 == 0) {
            max >>= 1;b >>= 1;
        }
        if (max % 3 == 0) {
            max /= 3; b /= 3;
        }
        bw.write(max + "/" + b + "\n");
        bw.flush();bw.close();
    }
}
