import java.io.*;

public class B2441 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String str = (j < i) ? " " : "*";
                sb.append(str);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());bw.flush();bw.close();
    }
}
