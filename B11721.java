import java.io.*;

public class B11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine();
        for (int i = 0; i < in.length(); i += 10) {
            if (i + 10 < in.length()) bw.write(in.substring(i, i + 10)+"\n");
            else bw.write(in.substring(i, in.length()) + "\n");
            bw.flush();
        }
        bw.close();
    }
}
