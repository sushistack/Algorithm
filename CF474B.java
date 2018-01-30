import java.io.*;

public class CF474B {
    static int n, m, a = 0, q, pile[] = new int[1000001];
    static String ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ins = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int b = a;
            a += Integer.parseInt(ins[i - 1]);
            for (int j = b + 1; j <= a; j++) {
                pile[j] = i;
            }
        }
        m = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        ins = br.readLine().split(" ");
        for (int i = 1; i <= m; i++) {
            q = Integer.parseInt(ins[i - 1]);
            sb.append(pile[q]);sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
