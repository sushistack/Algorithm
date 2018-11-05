import java.io.*;

public class Line1 {
    static int n, count;
    static char c[], cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            count = 1;
            c = br.readLine().toCharArray();
            cur = c[0];
            for (int j = 1; j < c.length; j++) {
                if (cur == c[j]) count++;
                else {
                    sb.append(count);
                    sb.append(cur);
                    count = 1;
                    cur = c[j];
                }
            }
            sb.append(count);
            sb.append(cur);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
