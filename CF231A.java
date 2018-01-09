import java.io.*;

public class CF231A {
    static int n, ans = 0, count;
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            ins = br.readLine().split(" ");count = 0;
            for (int j = 0; j < 3; j++) count += (ins[j].equals("1")) ? 1 : 0;
            ans += (count > 1) ? 1 : 0;
        }
        bw.write(ans + "\n");bw.flush();bw.close();
    }
}
