import java.io.*;

public class CFR473A {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        bw.write(n % 2 == 1 ? "Ehab\n" : "Mahmoud\n");
        bw.flush();bw.close();
    }
}
