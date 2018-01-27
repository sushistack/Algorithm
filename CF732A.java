import java.io.*;

public class CF732A {
    static int k, r, i = 1, ans;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        k = Integer.parseInt(ins[0]);
        r = Integer.parseInt(ins[1]);
        while (true) {
            if ((k * i - r) % 10 == 0 || (k * i) % 10 == 0) {
                ans = i; break;
            }i++;
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
