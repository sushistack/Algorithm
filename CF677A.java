import java.io.*;

public class CF677A {
    static int n, h, count = 0;
    static int[] a = new int[1001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        h = Integer.parseInt(ins[1]);
        ins = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            count += (Integer.parseInt(ins[i]) > h) ? 2 : 1;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
