import java.io.*;

public class B8393 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        bw.write((n * (n + 1)) / 2 + "\n");
        bw.flush();bw.close();
    }
}
