import java.io.*;

public class CF492A {
    static int n, ans = 0, j = 1, count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 2; ans <= n ; i++) {
            ans += j;j += i;
            count++;
        }
        bw.write(count + "\n");
        bw.flush();bw.close();
    }
}
