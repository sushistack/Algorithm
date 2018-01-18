import java.io.*;

public class CF318A {
    static long n, k, ans;
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ins = br.readLine().split(" ");
        n = Long.parseLong(ins[0]);
        k = Long.parseLong(ins[1]);
        if (n % 2 == 1)  ans = (k > ((n + 1) >> 1)) ? (k - ((n + 1) >> 1)) << 1 : (k << 1) - 1;
        else ans = (k > (n >> 1)) ? (k - (n >> 1)) << 1 : (k << 1) - 1;
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
