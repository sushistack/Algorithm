import java.io.*;

public class CF486A {
    static long n, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(br.readLine());
        ans = (n % 2 == 0) ? n/2 : n/2 - n;
        bw.write(ans + "\n");
        bw.flush();bw.close();
    }
}
