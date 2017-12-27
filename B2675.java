import java.io.*;

public class B2675 {
    static int N, R;
    static String str, in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            in = br.readLine();
            R = Integer.parseInt(in.split(" ")[0]);
            str = in.split(" ")[1];
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(str.charAt(j));
                }
            }
            bw.write(sb.toString() + "\n");
            bw.flush();
        }
        bw.close();
    }
}
