import java.io.*;

public class CFR473C {
    static int n, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (n < 6) sb.append("-1\n");
         else {
            for (int i = 2; i < 5; i++) {
                sb.append("1 ");sb.append(i);
                sb.append("\n");
            }

            for (int i = 5; i <= n; i++) {
                sb.append("2 ");sb.append(i);
                sb.append("\n");
            }
        }
        for (int i = 2; i <= n; i++) {
            sb.append("1 ");sb.append(i);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
