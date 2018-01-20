import java.io.*;

public class CF59A {
    static String in;
    static int upper = 0, lower = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        in = br.readLine();
        for (int i = 0; i < in.length(); i++) {
            upper += (in.charAt(i) < 96) ? 1 : 0;
            lower += (in.charAt(i) > 96) ? 1 : 0;
        }
        bw.write(((upper > lower) ? in.toUpperCase() : in.toLowerCase()) + "\n");
        bw.flush();bw.close();
    }
}
