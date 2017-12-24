import java.io.*;

public class B10871 {
    static int N, X;
    static String[] ins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine();
        N = Integer.parseInt(in.split(" ")[0]);
        X = Integer.parseInt(in.split(" ")[1]);
        StringBuffer sb = new StringBuffer();
        in = br.readLine();ins = in.split(" ");
        for (int i = 0; i < ins.length; i++) {
            sb.append((Integer.parseInt(ins[i]) < X) ? ins[i] + " " : "");
        }
        bw.write(sb.toString().substring(0, sb.length() - 1) + "\n");
        bw.flush();bw.close();
    }
}
