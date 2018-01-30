import java.io.*;

public class CF313B {
    static int m, prefix[] = new int[100001], l, r;
    static String in, ins[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        for (int i = 1; i < in.length(); i++) {
            if (i == 1) prefix[i] = (in.charAt(i) == in.charAt(i - 1)) ? 1 : 0;
            else {
                prefix[i] = prefix[i - 1];
                prefix[i] += (in.charAt(i) == in.charAt(i - 1)) ? 1 : 0;
            }
        }
        m = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            ins = br.readLine().split(" ");
            l = Integer.parseInt(ins[0]);
            r = Integer.parseInt(ins[1]);
            sb.append(prefix[r - 1] - prefix[l - 1]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();bw.close();
    }
}
