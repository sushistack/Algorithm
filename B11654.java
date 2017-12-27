import java.io.*;

public class B11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = br.readLine();
        bw.write((int)in.charAt(0) + "\n");
        bw.flush();bw.close();
    }
}
