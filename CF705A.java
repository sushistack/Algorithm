import java.io.*;

public class CF705A {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 2; i < n; i+=2) {
            sb.append("I hate that I love that ");
        }
        if (n % 2 == 0) sb.append("I hate that I love it");
        else sb.append("I hate it");
        bw.write(sb.toString() + "\n");
        bw.flush();bw.close();
    }
}
