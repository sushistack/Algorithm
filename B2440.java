import java.io.*;

public class B2440 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = N; i > -1; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());bw.flush();bw.close();
    }
}
