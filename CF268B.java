import java.io.*;

public class CF268B {
    static int n, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ans = n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            ans += i * (n - i);
        }
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }


}
